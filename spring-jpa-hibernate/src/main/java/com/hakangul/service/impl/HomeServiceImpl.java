package com.hakangul.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hakangul.dto.DtoHome;
import com.hakangul.dto.DtoRoom;
import com.hakangul.entities.Home;
import com.hakangul.entities.Room;
import com.hakangul.repository.HomeRepository;
import com.hakangul.service.IHomeService;

@Service
public class HomeServiceImpl implements IHomeService {

    @Autowired
    private HomeRepository homeRepository;

    @Override
    public DtoHome findHomeById(Long id) {
        DtoHome dtoHome = new DtoHome();
        Optional<Home> opt = homeRepository.findById(id);

        if (opt.isEmpty()) {
            return null;
        }

        Home dbHome = opt.get();
        List<Room> dbRooms =  dbHome.getRoom();
        BeanUtils.copyProperties(dbHome, dtoHome);

        if(dbRooms != null && !dbRooms.isEmpty()) {
            dbRooms.forEach(room -> {
                DtoRoom dtoRoom = new DtoRoom();
                BeanUtils.copyProperties(room, dtoRoom);
                dtoHome.getRooms().add(dtoRoom);
            });
        } 


        return dtoHome;
    }

}
