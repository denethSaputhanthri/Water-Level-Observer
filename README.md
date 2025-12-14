# 🌊 Water Level Observer

**Water Level Observer** is an automated IoT-based system designed to monitor water tank levels in real-time. It aims to solve common household and industrial water management issues, such as water wastage due to tank overflow and pump damage due to dry running.

## 🚀 Key Features

* **Real-time Monitoring:** Continuously measures the distance to the water surface using ultrasonic technology.
* **Automatic Pump Control:**
    * Turns **OFF** the pump when the tank is full (preventing overflow).
    * Turns **ON** the pump when water levels are critically low.
* **Visual Indicators:** Uses LEDs (Red/Green) or an LCD display to show current status.
* **Dry Run Protection:** Ensures the pump does not run when there is no water to pump.
* **Cost-Effective:** Built using affordable, off-the-shelf components.

## 🛠️ Hardware Requirements

* **Microcontroller:** Arduino Uno / Nano / ESP8266
* **Sensor:** HC-SR04 Ultrasonic Sensor
* **Actuator:** Relay Module (5V/12V)
* **Display:** 16x2 LCD (I2C) or Simple LEDs
* **Power:** 5V/12V Power Supply
* **Wiring:** Jumper wires and Breadboard/PCB

## 🔌 Circuit Logic

1.  The **Ultrasonic Sensor** emits sound waves to calculate the distance to the water level.
2.  The **Microcontroller** processes this distance into a percentage (0% to 100%).
3.  Based on the percentage:
    * If **Level < 20%**: Relay triggers Pump **ON**.
    * If **Level > 90%**: Relay triggers Pump **OFF**.

## 💻 Tech Stack

* **Language:** C++ (Arduino)
* **IDE:** Arduino IDE
* **Libraries Used:**
    * `NewPing` (For efficient sonar reading)
    * `LiquidCrystal_I2C` (For LCD display)

## ⚙️ How to Run

1.  Clone this repository:
    ```bash
    git clone [https://github.com/denethSaputhanthri/Water-Level-Observer.git](https://github.com/denethSaputhanthri/Water-Level-Observer.git)
    ```
2.  Open the `.ino` file in the Arduino IDE.
3.  Install the required libraries via the **Library Manager**.
4.  Connect your Arduino to the PC and select the correct Board and COM Port.
5.  **Upload** the code.
6.  Assemble the circuit according to the pin definitions in the code.
