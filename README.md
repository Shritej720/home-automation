# Home-Automation-using-mqtt-and-android
This project uses Emq X as a broker https://www.emqx.io/ 
In this project we have built an android application which is used to connect to home devices via Internet. 
 Here the devices are connected to relay which can be controlled by node MCU which is connected to Arduino IDE and MQTT server.
 Arduino code design in such way that user can send a command to nodemcu which is connecting to mqtt server 
 Android code is used to give access to autherize user, first create user in EMQ x server then try to log in using android application 