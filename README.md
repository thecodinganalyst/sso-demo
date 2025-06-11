# SSO Demo - Spring Boot + Azure AD

This project demonstrates how to implement **Single Sign-On (SSO)** in a Spring Boot application using **OAuth2 / OpenID Connect (OIDC)** with **Azure Active Directory (Azure AD)**.

### ✅ Features
- OAuth2 Login via Azure AD 
- Secured endpoints 
- Thymeleaf frontend with login/logout and user info

### 🔧 Requirements
* Java 17+
* Maven
* Azure Active Directory (for SSO)
* Azure app registration with:
*     Redirect URI: http://localhost:8080/login/oauth2/code/azure

### ☁️ Azure Configuration
To use Azure AD for SSO, follow these steps to register your application:

#### 1. Register an App in Azure AD
* Go to Azure Portal 
* Navigate to: Azure Active Directory → App registrations → New registration 
* Set a Name (e.g., sso-demo-app)
* Set the Redirect URI to `http://localhost:8080/login/oauth2/code/azure`
* Click Register

#### 2. Configure the App
After registration:
* Go to Overview and copy:
  * Application (client) ID → used as client-id 
  * Directory (tenant) ID → used in the issuer-uri 
* Go to Certificates & secrets:
  * Click New client secret 
  * Copy the generated value → used as client-secret

#### 3. Set API Permissions
* Go to API permissions 
* Click Add a permission → Microsoft Graph 
* Select:
  * openid 
  * profile 
  * email 
  * User.Read 
* Click Grant admin consent

### 🚀 Running the Project
For running in IntelliJ, rename the file `.env.sample` to `.env`, and update the values. Install EnvFile plugin (https://plugins.jetbrains.com/plugin/7861-envfile) and restart IntelliJ. In the spring-boot:run plugin in the Maven tool window, right-click and select `Modify Run Configuration`, the `Enable EnvFile` checkbox should be available.
Check it, as well as the 1st option - `Substitute Environment Variables`, and the environment variables in the application.yml will be replaced by the values in the `.env` file.

Alternatively, these environment variables can be created in system variables or in the java options when modifying the run configurations

For deployment, these can be created in the secrets in the CI/CD environment.
