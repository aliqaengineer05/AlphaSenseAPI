FROM ubuntu:18.04
MAINTAINER AhmedAli "ali.qaengineer@gmail.com"

WORKDIR /root
ENV USER /root

RUN sed -i 's/# \(.*multiverse$\)/\1/g' /etc/apt/sources.list
RUN apt-get autoclean
RUN apt-get clean
RUN apt-get update
RUN apt-get -y dist-upgrade
RUN apt-get -y upgrade
RUN apt-get -y --no-install-recommends install openjdk-8-jdk
RUN apt-get -y --no-install-recommends install maven
RUN apt-get -y install curl
RUN apt-get -y install git
RUN curl https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb -o /chrome.deb
RUN dpkg -i /chrome.deb || apt-get install -yf
RUN rm /chrome.deb
