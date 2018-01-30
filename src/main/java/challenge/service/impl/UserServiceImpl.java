package challenge.service.impl;

import challenge.domain.User;
import challenge.dto.PairUserListDto;
import challenge.repository.UserRepository;
import challenge.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User findById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public Map<String, String> userListWithMostPopulerPair(){
        List<PairUserListDto> pairUserListDtoList = userRepository.pairUserListDtoList();
        HashMap<String, String> pairMap = new HashMap<>();
        for(PairUserListDto dto : pairUserListDtoList){
            String populerFollower = userRepository.findById(dto.getMostPopulerFollowerId()).getUsername();
            if(pairMap.containsKey(dto.getUsername())){
                String value = pairMap.get(dto.getUsername());
                StringBuilder builder = new StringBuilder();
                pairMap.remove(dto.getUsername());
                pairMap.put(dto.getUsername(),builder.append(value).append(",").append(populerFollower).toString());
            }else{
                pairMap.put(dto.getUsername(),populerFollower);
            }
        }
        return pairMap;
    }
}
