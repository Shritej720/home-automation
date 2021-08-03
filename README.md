# Home-Automation-using-mqtt-and-android
This project uses Emq X as a broker https://www.emqx.io/ 
In this project we have built an android application which is used to connect to home devices via Internet. 
 Here the devices are connected to relay which can be controlled by node MCU which is connected to Arduino IDE and MQTT server.
 Arduino code design in such way that user can send a command to nodemcu which is connecting to mqtt server 
 Android code is used to give access to autherize user, first create user in EMQ x server then try to log in using android application
 <h6>You need following software and hardware for this project: <h6>
 (1)Arduino IDE g
 <br>
 (2)Nodemcu/ESP8266 
 <br>
 (3)2/4 channel Relay 
 <br>
 (4)Jumper wire
 <br>
 (5)Breadboard
 <br>
 (6)Bulb
 <br>
 (7)Electric Wire and two pin 
 <br>
 (8)Android Studio, I've used Kotlin for making android application.
 <br>
 (9)MQTT broker EMQ-X https://www.emqx.io/
 <br>

<h1>first step:</h1>
set up your Arduino IDE, download libraries(PubsubClient), go through this https://www.emqx.io/blog/esp8266-connects-to-the-public-mqtt-broker documentation it will give you idea of how to connect your nodemcu to EMQX broker
Add SSID of your wifi, add username and password created in EMQX server, define your pins. 
<h1>second step:</h1> 
After connecting nodemcu to mqtt broker, make your own android App, use this link https://www.emqx.io/blog/android-connects-mqtt-using-kotlin for better understading of how to connect android application to EMQX broker. You'll need some dependencies.
This android has login page, dashboard and control button. 

<h1>EMQX setup:</h1>
(1) Create user in EMQX broker
<br>
(2) Create ClientID, clientid will be use for nodemcu, Each nodemcu has its own ClientID
<br>
(3) Assign one topic to ClientID, topic is different for every clientID, but user can access multiple topic and clientID.
<br>
(4) Assign topic to user by default topic is accessable for every user, so deny access to all user and give access to authenicated user
