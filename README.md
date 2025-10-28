# 🇩🇿 Algeria Traffics: Shortest Path Finder

## 💡 Overview

Algeria Traffics is a Java-based desktop application that calculates and visualizes the shortest route between major Algerian cities using **Dijkstra's Algorithm**.

The application provides a graphical user interface (GUI) displaying a simplified map of Algeria. Users can select a source and destination city, and the application will determine the minimum travel distance and highlight the optimal path on the map.

---

## ✨ Features

* **Shortest Path Calculation:** Implements **Dijkstra's algorithm** to efficiently find the route with the minimum total distance between any two selected cities.
* **Interactive GUI:** Built with Java Swing/AWT for an intuitive user experience, featuring dropdown boxes and control buttons.
* **Map Visualization:** Displays a simplified, color-coded map of Algeria and neighboring regions.
* **Route Highlighting:** The determined shortest path is visually highlighted in **red** on the map.
* **Distance and Path Output:** Outputs the minimum distance in Kilometers and the sequence of cities forming the shortest path as text.

---

## 🛠️ Technologies Used

* **Language:** Java
* **GUI Library:** Java Swing & AWT (`JFrame`, `JPanel`, `Graphics2D`, `JComboBox`, etc.)
* **Algorithm:** Dijkstra's Algorithm for graph search

---

## 🚀 Getting Started

### Prerequisites

You need to have the following installed on your system:

* **Java Development Kit (JDK)** (version 8 or later is recommended)

### Installation and Execution

1.  **Clone the Repository:**
    ```bash
    git clone https://github.com/Ogrimagy/Algeria_Traffic.git
    cd Project
    ```

2.  **Compile the Java Files:**
    Compile all the source files in the `Project` directory:
    ```bash
    javac Project/*.java
    ```

3.  **Run the Application:**
    Execute the main class, `Execute.java`:
    ```bash
    java Project.Execute
    ```

---

## 🧑‍💻 How to Use

1.  **Launch the Application:** Run the `Execute.java` file as described above. A window titled "Algeria Map" will open.
2.  **Select Cities:** Use the **"From"** and **"To"** dropdown menus to select your starting and ending cities.
    * *Note: If you select the placeholder index (0) or the same city twice, the application displays an "Erreur!" message.*
3.  **Calculate Path:** Click the **"valider"** button.
4.  **View Results:**
    * The shortest path will be drawn in **red** on the map.
    * The minimum distance and the sequence of cities will be displayed as text results.
5.  **Reset:** Click the **"reinitialiser"** button to clear the results, reset the city selections, and remove the highlighted path from the map.

---

## 🛣️ City Graph Representation

The graph is an undirected, weighted graph where the nodes are 11 major Algerian cities (indexed 1 through 11), and the weights (distances) are abstracted from the Euclidean distance between their hardcoded screen coordinates on the map.
