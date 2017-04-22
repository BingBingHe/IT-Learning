# Git

### 1、创建版本库
首先，选择一个合适的地方创建空目录：

	$ mkdir mkdir learngit 
	$ cd learngit
	$ pwd
	/Users/redup/develop/GitHub/learngit

然后通过`git init`命令把这个目录变成了Git可以管理的目录。

相应地，目录下回多出一个`.git`的目录，这个目录是Git用来追中管理版本库的。
> 其实这里的版本库是基于本地安装的Git来进行管理的，让文件夹成为一个便于管理的文件夹。能够通过命令来及时的发现内容是否改变、并做到及时提醒，甚至到最后与远程的版本库Github进行同步。 

### 2、将文件添加到版本库

所有的版本控制系统都只能跟踪文本文件的改动，又由于文本是有编码的，所以推荐使用标准的`UTF-8`编码，使得所有平台都支持。

编写一个新文件或者修改文件后，分两步走，提交到Git仓库：

- 用命令`git add`告诉Git，究竟是哪些文件做了修改、删除、添加 **（Stage操作，添加到仓库）**：

		$ git add readme.txt 	//直接指定对应的文件名
		$ git add readme.txt readme_2.txt	 //也可以指定多个
		$ git add .  //把所有变动的文件都提交上去
		$ git add --all //把所有变动的文件都提交上去
	下图是`Git Version 2.x`使用的命令效果：
	![git Version 2.x](http://ootah442n.bkt.clouddn.com/KwOLu.jpg)

- 用命令`git commit`告诉Git，可以将修改正式地提交给仓库 **（Commit操作，提交到仓库）**

		$ git commit -m "wrote a readme file"  
		// -m 参数表示对提交的说明，方便今后从历史记录中查询
		
	当然，可以分多次`git add`后，在统一进行`git commit`操作

### 3、查看命令
- 命令`git status`可以让我们时刻掌握仓库当前的状态，包括修改、提交、差异等。
- 命令`git diff`来查询文件具体是修改了什么内容，例如：
		
		$ git diff readme.txt
		
		diff --git a/readme.txt b/readme.txt		index 46d49bf..9247db6 100644		--- a/readme.txt		+++ b/readme.txt		@@ -1,2 +1,2 @@		-Git is a version control system.		+Git is a distributed version control system.		 Git is free software

