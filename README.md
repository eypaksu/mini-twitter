 #mini-twitter
 The app including some basic functionalties similar twitter's
 
 Also you can check the http://localhost:8080/swagger-ui.html for api documentation
 
 #Endpoints
- api/user/messages (GET) all messages by user's following list
- api/user/messages/?search="" get messages with search param

example : http://localhost:8080/api/user/message?search=elit

- api/user/followers (GET)

example : http://localhost:8080/api/user/followers Returning followers for current user.

- api/user/followingList (GET) Returning following list for current user.

example : http://localhost:8080/api/user/followingList 

- api/user/unfollow/{long unfollowUserId} Returning following list without the user which is unfollowed.

example : http://localhost:8080/api/user/unfollow/{2}

- api/user/follow/{long followUserId} (PUT) Returning following list with new user which is started follow.  

example : http://localhost:8080/api/user/follow/{2} 

- api/userListWithMostPopulerPair (GET) Return all users with most populer pairs.

example : http://localhost:8080/api/userListWithMostPopulerPair


# Testing

- Unit tests also using same sql schema and data.
- Postman collection also will share 

# Notes

- Spring-Security Basic Authentication done for all api.Username is same and the password is "passoword" for each user.(username:batman, password:"passowd")
- Please check also for lombok plugin for your IDE
 

 

 
 
   