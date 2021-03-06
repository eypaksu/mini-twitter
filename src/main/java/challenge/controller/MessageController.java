package challenge.controller;

import challenge.dto.MessageResponseDto;
import challenge.repository.impl.UserRepositoryImpl;
import challenge.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/user")
@RestController
public class MessageController {

    @Autowired
    private UserRepositoryImpl userRepository;

    @Autowired
    private MessageService messageService;

    @RequestMapping(value = "/messages", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> getMessageByUser(@RequestParam(value="search", required = false) String search) {
        String username = getUsernameFromAuthentication();
        Long userId = userRepository.findByUsername(username).getId();
        List<MessageResponseDto> messageResponseDtoList =messageService.findMessageListByUser(userId, search);
        if(!messageResponseDtoList.isEmpty()){
            return new ResponseEntity<>(messageResponseDtoList, HttpStatus.OK);
        }
        if(messageResponseDtoList.isEmpty()){
            return new ResponseEntity<>("no related message with this user", HttpStatus.OK);
        }
        return new ResponseEntity<>("Bad Gateway", HttpStatus.BAD_GATEWAY);
    }

    //for request from ui passing automatically authentication
    //to show messages for user batman
    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value = "/messagesUi", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<?> getMessageFromUi(@RequestParam(value="search", required = false) String search) {
        String username = "batman";
        Long userId = userRepository.findByUsername(username).getId();
        List<MessageResponseDto> messageResponseDtoList =messageService.findMessageListByUser(userId, search);
        if(!messageResponseDtoList.isEmpty()){
            return new ResponseEntity<>(messageResponseDtoList, HttpStatus.OK);
        }
        if(messageResponseDtoList.isEmpty()){
            return new ResponseEntity<>("no related message with this user", HttpStatus.OK);
        }
        return new ResponseEntity<>("Bad Gateway", HttpStatus.BAD_GATEWAY);
    }


    public String getUsernameFromAuthentication(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getName(); //get logged in username
    }

}
