FROM centos:7

MAINTAINER ntkkni

RUN echo 'root:root' |chpasswd

RUN useradd defaultuser
RUN echo 'defaultuser:defaultuser' |chpasswd

#取り敢えずyumをアップデートする
RUN yum -y update

RUN yum -y install unzip

# Time Zoneの設定
RUN echo 'ZONE="Asia/Tokyo"' > /etc/sysconfig/clock
RUN yum -y install ntp &&\
    yum -y clean all
RUN rm -f /etc/localtime
RUN ln -fs /usr/share/zoneinfo/Asia/Tokyo /etc/localtime

# Jenkinsインストールに必要なパッケージインストール
RUN yum -y install wget
RUN yum -y install java-1.8.0-openjdk-devel
RUN yum -y install initscripts


# jenkins yumリポジトリ登録
RUN wget -O /etc/yum.repos.d/jenkins.repo http://pkg.jenkins-ci.org/redhat/jenkins.repo
RUN rpm --import http://pkg.jenkins-ci.org/redhat/jenkins-ci.org.key


#アプリケーション周りの権限を設定する
USER root
WORKDIR /root

RUN curl -LO -b "oraclelicense=accept-securebackup-cookie" "http://download.oracle.com/otn-pub/java/jdk/8u172-b11/a58eab1ec242421181065cdc37240b08/jdk-8u172-linux-x64.rpm"

RUN rpm -ivh jdk-8u172-linux-x64.rpm

RUN mkdir -p /usr/local/app
RUN chown defaultuser:defaultuser /usr/local/app
RUN mkdir -p /var/log/history
RUN chown defaultuser:defaultuser /var/log/history

USER defaultuser

ADD start.sh /home/defaultuser/
ADD play-sample-1.0-SNAPSHOT.zip /usr/local/app/

WORKDIR /usr/local/app/
RUN unzip play-sample-1.0-SNAPSHOT.zip

USER root
RUN chown -R defaultuser:defaultuser /usr/local/app
RUN chown -R defaultuser:defaultuser /home/defaultuser/

WORKDIR /home/defaultuser/

EXPOSE 9000


