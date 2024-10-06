# Coding Challenge

## Overview
This project is designed as part of the Coding Challenge for Entrata.com, focusing on Selenium test automation.

## Getting Started
To set up and run the Selenium tests for the Entrata.com coding challenge, follow these steps. Ensure you have the required software installed on your machine.

### Prerequisites
Before you begin, make sure you have the following installed:
- **Java JDK 11+**: Download from [Oracle](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) or use [OpenJDK](https://openjdk.java.net/install/).
- **Maven 3.6+**: Download from [Maven's official website](https://maven.apache.org/download.cgi).
- **Git**: Download from [Git's official website](https://git-scm.com/).
- **WebDriver**: Install the appropriate WebDriver for your browser (e.g., ChromeDriver for Google Chrome). Ensure that the WebDriver executable is in your system's PATH

### Installation
```bash
# Clone the repository
git clone https://github.com/SushantMali0608/entrata-test.git

# Navigate to the project directory
cd entrata-test/EntrataTestcaseDesign

# Install dependencies
mvn install

# Run Test Cases
mvn verify
