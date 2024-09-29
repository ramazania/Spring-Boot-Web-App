## Project Overview
This is a customer relationship management (CRM) system built using Spring Boot and Vaadin. It allows users to manage contacts, including features like sorting, filtering, and adding new contacts. The application is deployed on the Render Cloud platform.

## Deployed on Render Cloud
The application is live and can be accessed here: [CRM Web App](https://webapp-latest.onrender.com/login)

## Running the application locally
1. Run the Application class directly from your IDE.

2. The project is a standard Maven project. To run it from the command line,
type `mvnw` (Windows), or `./mvnw` (Mac & Linux), then open
http://localhost:8080 in your browser.

You can also import the project to your IDE of choice as you would with any
Maven project. Read more on [how to import Vaadin projects to different IDEs](https://vaadin.com/docs/latest/guide/step-by-step/importing) (Eclipse, IntelliJ IDEA, NetBeans, and VS Code).

## Project structure

- `MainLayout.java` in `src/main/java` contains the navigation setup (i.e., the
  side/top bar and the main menu). This setup uses
  [App Layout](https://vaadin.com/docs/components/app-layout).
- `views` package in `src/main/java` contains the server-side Java views of your application.
- `views` folder in `src/main/frontend` contains the client-side JavaScript views of your application.
- `themes` folder in `src/main/frontend` contains the custom CSS styles.
