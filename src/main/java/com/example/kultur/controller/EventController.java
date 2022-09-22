package com.example.kultur.controller;
import com.example.kultur.bandservice.IBandService;
import com.example.kultur.eventservice.IEventService;
import com.example.kultur.model.Band;
import com.example.kultur.model.Event;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
public class EventController {

    private IEventService iEventService;
    private IBandService iBandService;

    public EventController(IEventService eventService, IBandService iBandService) {
        this.iEventService = eventService;
        this.iBandService = iBandService;
    }

    @PostMapping("/createEvent")
    public ResponseEntity<String> createEvent(@RequestBody Event event, @RequestParam Long bandID)     {
        Optional<Band>  band_ = iBandService.findById(bandID);
        if (band_.isPresent()){
            event.setBand(band_.get());
            iEventService.save(event);
            return new ResponseEntity<>("OK", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Could not create", HttpStatus.OK);
        }

    }
    @GetMapping("/getAllEvents")
    public ResponseEntity<String> read() {
        if (!iEventService.findAll().isEmpty()) {
            return new ResponseEntity<>("All events: " + iEventService.findAll(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Table is empty!", HttpStatus.OK);
        }
    }
}
