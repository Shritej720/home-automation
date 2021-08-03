#include <ESP8266WiFi.h>
#include <PubSubClient.h>

// WiFi
//try to add router wifi not mobile hotspot
const char *ssid = "";           // Enter your WiFi name
const char *password = ""; // Enter WiFi password 

// MQTT Broker
const char *mqtt_broker = "wcf75e2b.us-east-1.emqx.cloud";
const char *topic = "N2C2"; //add topic here, youve created in EMQ X
const char *mqtt_username = ""; //add username created in mqtt server i.e EMQ X
const char *mqtt_password = ""; //add password created in mqtt server i.e EMQ X
const int mqtt_port = 15189;    //add port number, you will get it when you login into EMQ X
const int input_pin = 5;      // declare input pins here, whatever input pins you're using, //input_pin = 5 is gpio pin of D1
const int input_pin1 = 15;    
const char *clientId = "shritej_n2"; //add clientID created in mqtt server i.e EMQ X


WiFiClient espClient;
PubSubClient client(espClient);
unsigned long lastMsg = 0;
#define MSG_BUFFER_SIZE  (50)
char msg[MSG_BUFFER_SIZE];
int value = 0;

void setup_wifi() {

  delay(10);
  // We start by connecting to a WiFi network
  Serial.println();
  Serial.print("Connecting to ");
  Serial.println(ssid);

  WiFi.mode(WIFI_STA);
  WiFi.begin(ssid, password);

  while (WiFi.status() != WL_CONNECTED) {
    delay(500);
    Serial.print(".");
  }

  randomSeed(micros());

  Serial.println("");
  Serial.println("WiFi connected");
  Serial.println("IP address: "); //it will desplay ip address and wifi connection on serial monito
  Serial.println(WiFi.localIP());
}

void callback(char* topic, byte* payload, unsigned int length) {
  Serial.print("Message arrived [");
  Serial.print(topic);
  Serial.print("] ");
  for (int i = 0; i < length; i++) {
    Serial.print((char)payload[i]);
  }
  Serial.println();

  // Switch on the LED if an 1 was received as first character
  //following if statement is yoused to power on and power off using input 
  
  if ((char)payload[0] == '1') {
    //if input value is 1 input_pin that is d1 will power on
    digitalWrite(input_pin, HIGH); 
  } 
  
  if ((char)payload[0] == '0') {
    //if input value is 0 input_pin that is d1 will power off
    digitalWrite(input_pin, LOW); 
  }
  
  if ((char)payload[0] == '3'){
    digitalWrite(input_pin1, HIGH);
  }
  if ((char)payload[0] == '2'){
    digitalWrite(input_pin1, LOW);
  }
  

}

void reconnect() {
  // Loop until we're reconnected
  while (!client.connected()) {
    Serial.print("Attempting MQTT connection...");
    // Create a random client ID

    // Attempt to connect
//    client.connect("shashank, mqtt_username, mqtt_password) 
    if (client.connect(clientId, mqtt_username, mqtt_password)) {
      Serial.println("connected");
      // Once connected, publish an announcement...
      client.publish(topic, "hello world");
      // ... and resubscribe
      client.subscribe(topic);
    } else {
      Serial.print("failed, rc=");
      Serial.print(client.state());
      Serial.println(" try again in 5 seconds");
      // Wait 5 seconds before retrying
      delay(5000);
    }
  }
}

void setup() {
  pinMode(input_pin, OUTPUT); // Initialize the BUILTIN_LED pin as an output
  pinMode(input_pin1, OUTPUT);
  Serial.begin(115200);
  setup_wifi();
  client.setServer(mqtt_broker, mqtt_port);
  client.setCallback(callback);
}

void loop() {

  if (!client.connected()) {
    reconnect();
  }
  client.loop();

  unsigned long now = millis();
  if (now - lastMsg > 2000) {
    lastMsg = now;
    ++value;
    snprintf (msg, MSG_BUFFER_SIZE, "hello world #%ld", value);
    Serial.print("Publish message: ");
    Serial.println(msg);
 client.publish(topic, msg);
  }
}
