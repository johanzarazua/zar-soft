<div align="center">
    <img src="imgs/logo_transparente.png" alt="Zarsoft logo" height="70px">
    <h1>
        <a href="https://www.zar-soft.com">www.zar-soft.com</a>
    </h1>
    <h4>
    <b>New website for the Zarsoft startup</b></h4>
    <h4>
        <a href="#project-structure">Project structure</a>
        •
        <a href="#built-with">Built with</a>
        •
        <a href="#deployment">Deployment</a>
        •
        <a href="#contact">Contact</a>
    </h4>
    <h3>
        <a href="https://www.github.com/johanzarazua">
            <img src="https://img.shields.io/badge/maintainer-%40johanzarazua-yellow">
        </a>
        <a href="https://www.zar-soft.com">
            <img src="https://img.shields.io/website?url=http%3A%2F%2Fwww.zar%2Dsoft.com%2F">
        </a>
        <!-- <img src="https://img.shields.io/badge/launched-february%202024-teal"> -->
        <a href="https://github.com/johanzarazua/zar-soft/commits/main">
            <img src="https://img.shields.io/github/last-commit/johanzarazua/zar-soft?color=blue&label=updated">
        </a>
    </h3>
</div>

Zarsoft is a startup dedicated to the creation of personalized software with the idea of ​​creating any type of project from web applications, mobile applications, desktop applications, etc., that helps facilitate daily processes with the help of modern technologies.

<!-- ## Table of contents
* [Project structure](#project-structure)
* [Built with](#built-with)
  * [Backend](#backend)
  * [Frontend](#frontend) -->
  
## Project Structure
The project is divided into two parts backend and frontend.
The frontend shows us the page with zarsoft information, what services it offers, how it works, the technologies they use and a registration form where you can send contact information about a project you want to develop.
The backend is responsible for receiving the information from the form and storing it in a database, for this it has different APIs for data registration and query, in addition to having a connection to an autonomous Oracle Cloud database (Autonomous Databases).

## Built with

<!-- <p align="center">
  <a href="https://skillicons.dev">
    <img src="https://skillicons.dev/icons?i=angular,java,spring,maven&theme=light" />
  </a>
</p> -->

<div align="center">
    <h3>
        <img src="https://img.shields.io/badge/-Angular-05122A?style=flat&logo=Angular"/>
        <img src="https://img.shields.io/badge/-Java-05122A?style=flat&logo=openjdk&logoColor=white"/>
        <img src="https://img.shields.io/badge/-spring%20boot-05122A?style=flat&logo=Spring&logoColor=white"/>
        <img src="https://img.shields.io/badge/-Git-05122A?style=flat&logo=git"/>
        <img src="https://img.shields.io/badge/-GitHub-05122A?style=flat&logo=github"/>
        <img src="https://img.shields.io/badge/-Intellij%20Idea-05122A?style=flat&logo=intellij-idea&logoColor=wirhe"/>
        <img src="https://img.shields.io/badge/-Visual%20Studio%20Code-05122A?style=flat&logo=visual-studio-code&logoColor=007ACC"/>
    </h3>
</div>


The project was created using Angular for the frontend with the following versions
Angular CLI: 16.2.1
Node: 18.17.1
Package Manager: npm 9.6.7

Java with maven and spring boot for the backend with the following versions
Apache Maven 3.9.6
Java version: 17.0.9

## Deployment

<!-- <p align="center">
  <a href="https://skillicons.dev">
    <img src="https://skillicons.dev/icons?i=docker,aws&theme=light" />
  </a>
</p>  -->

<div align="center">
    <h3>
        <img src="https://img.shields.io/badge/-Docker-05122A?style=flat&logo=docker"/>
        <img src="https://img.shields.io/badge/-AWS-05122A?style=flat&logo=amazon"/>
    </h3>
</div>

To install the project, docker and docker compose were used. Currently both the backend and frontend are installed on an AWS EC2 instance, while the database is in OCI.

In order to deploy the project, Dockerfiles and docker-compose.yml files were used. The dockerfiles are used to generate independent images of the frontend and backend, while the docker-compose.yml allowed us to add some other containers (nginx-proxy, letsencrypt-nginx-proxy-companion) in order to have a server to host the forntend and a companion that installs and updates SSL certificates automatically on our website


## Contact
<p align="center">
  <a href="hmailto:johanzarazua@gmail.com">
    <img src="https://skillicons.dev/icons?i=gmail&theme=light" />
  </a>
  &nbsp;
  <a href="https://www.facebook.com/people/ZarSoft/100070710405578/?mibextid=LQQJ4d" target="blank">
    <img
      src="https://raw.githubusercontent.com/rahuldkjain/github-profile-readme-generator/master/src/images/icons/Social/facebook.svg"
      alt="adam pithen wala" height="50" width="50" />
  </a>
  &nbsp;
  <a href="https://www.instagram.com/zar.soft/">
    <img src="https://skillicons.dev/icons?i=instagram&theme=light" />
  </a>
  <!-- &nbsp;
  <a href="https://skillicons.dev">
    <img src="https://skillicons.dev/icons?i=linkedin&theme=light" />
  </a> -->
  
  
</p> 