### Linux 学习笔记

#### 宝塔面板

ip地址：http://47.106.90.148:8888/

用户名：vqv5g5iy

密码：e78ccc1c

### xftp 和xshell

#### Linux操作命令或快捷键

> CTRL+鼠标滚轮

> clear 清除

> cd / ls 目录

> ==tar -zxyf== 解压文件

==Linux没有输出就代表没错==

> ==sync== #同步数据
>
> ==shutdown== #关机命令
>
> -h 10 #10分钟后关机
>
> -h now #立刻关机
>
> -h 20:25 #系统在20：25关机
>
> -h +10 #10分中后关机
>
> -r now # 立即重启
>
> ==reboot== #重启
>
> ==halt== #关闭系统

> /opt ==安装文件夹==

### 常用的基本命令

##### 目录管理

> 绝对路径 想对路径

> cd命令绝对路径都是以/开头 想对路径是(../../)

==cd==：切换目录命令

cd .. ：返回上级命令

cd ./ :当前目录

> ls 列出目录文件

==ls==：列出 目录

ls -a ：all 查看全部文件

ls -l  :列出所有的文件包含属性和权限，没有隐藏文件

> pwd 回到当前用户目录

> makdir 创建一个目录

==makdir -p== /888/88/88 创建多级目录

> rmdir 删除目录只能删除空的文件

==rmdir -p==递归删除

> cp 复制

cp 原来的文件 新的位置 如果重复 就选择覆盖y 或者放弃n

> rm （移除目录或文件）

-f 强制删除

-r 递归删除目录

-i 互动询问是否删除

> ==rm -rf /*== 删库跑路

> mv 移动 重命名文件夹

-f 强制移动

-u 只替换已经更新过的文件

> chmod 更改文件的9个属性 chmod +3个数字+文件名

r:4 w:2 x:1

root rwx 7

group rwx 7

others rwx 7

##### 文件内容查看

* cat 文件由第一行开始显示 读取配置文件

* tac 文件由最后一行开始显示

* nl 显示的时候带有行号
* more 一页页的显示空格翻页 回车下一行 f行号
* less 一页页的显示 与more 类似 上下键翻动页面 q退出 ==/==查询字符串 ==？==向下查找 ==n==继续执行下一个 N上一个
* head -n 10 看前面10行
* tail -n 倒着看10行

##### 链接

软连接 ln -s

硬链接 ln

#### Vim 编辑器

vim 文件

##### 进程管理

==ps== 查看系统中当前执行的各种进程的信息

* ps -a 显示当前终端运行的所有进程信息
* -u 以用户的信息显示进程
* -x 显示后台运行进程的参数
* -ef 可以查看父进程的信息

pstree -pu

-p:显示父id

-u:显示用户组

````
ps -aux
ps -aux|grep mysql
ps -aux|grep java
| Linux管道符  A|B
grep 查找文件中符合条件的字符串

````

结束进程

kill -9 进程的id

==让程序后台执行==

nohup command &

##### 环境安装

三种 rpm 解压缩 yum 在线安装

jdk（rpm 安装 布置Spring Boot 项目 ）

安装jdk:rpm -ivh jdk-8u271-linux-x64.rpm

卸载jdk:

* rpm -qa|grep jdk
* rpm -e --nodeps jdk1.8-1.8.0_271-fcs.x86_64

配置jdk环境变量

/etc/profile 增加

````bash
JAVA_HOME=/usr/java/jdk1.8.0_271-amd64
CLASSPATH=%JANA_HOME%/lib;%JANA_HOME%/jre/lib
PATH=$JAVA_HOME/bin;$JAVA_HOME/jre/bin
export PATH CLASSSPATH JAVA_HOME 
````

让这个配置文件生效

source /etc/profile

> 查看端口情况：

firewall-cmd --list-port

> 开启8080端口

firewall-cmd --zone=public --add-port=8080/tcp --permanent

> 重启防火墙

systemctl restart firewalld.service

vim /etc/profile

tomecat （解压缩安装 ）

