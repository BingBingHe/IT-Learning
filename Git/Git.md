# Git

> @authur Bingbing He,
> 2017/04/22

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
		
		diff --git a/readme.txt b/readme.txt
		index 46d49bf..9247db6 100644
		--- a/readme.txt
		+++ b/readme.txt
		@@ -1,2 +1,2 @@
		-Git is a version control system.
		+Git is a distributed version control system.
		 Git is free software

### 4、远程仓库连接

本地Git仓库和GitHub仓库的传输是通过SSH加密的，所以需要设置：

- **第1步：**创建SSH Key。通过命令：

		$ ssh-keygen -t rsa -C "youremail@example.com"

	即会在用户的主目录下生成.ssh目录，包含有`id_rsa`和`id_rsa.pub`两个文件，这两个是SSH Key的秘钥对。
- **第2步：**登录GitHub，打开“Account setting”，“SSH Keys”页面 -> "Add SSH Key",在Key文本框里粘贴`id_rsa.pub`文件的内容，通过SSH Key来验证推送人是否本人。

	![Add Key](http://ootah442n.bkt.clouddn.com/add%20key.png)

### 5、添加远程库

将本地Git仓库与远程GitHub仓库关联起来的命令是：

	$ git remote add origin git@github:com:BingBingHe/learngit.git

其中BingBingHe是自己的GitHub账户名字，若想推送需要刚才的SSH Key的验证才可以。learngit.git是远程仓库名，用origin引出。
	
### 6、将本地库的内容推送到远程仓库

	git push -u origin master // 首次推送，-u操作便于把本地的分支与远程分支相关联。
	git push origin master 

通过上述命令，就可以将本地`master`分支的最新修改推送至GitHub。

### 7、从远程库克隆最新版本

克隆命令将从远程库中复制最新的版本到本地，也自动地关联了本地和远程的数据库。

	$ git clone git@github.com:BingBingHe/learngit.git

这个命令也常出现在Linux和Mac终端里面，通过git命令从远程下载文件、版本。

### 8、更新远程库至本地库

本地库落后于远程库，需要用命令将远程库的最新版本抽取下来并合并，通常有两种命令：

- `git fetch`命令,分为四个部分进行
	
		$ git fetch origin master:tmp //获取最新的版本，暂存在tmp分支里  
		$ git diff tmp	// 比较最新版本的分支与本地分支的区别
		$ git merge tmp	// 如果可以的话，就直接与本地分支合并，算是用最新的覆盖掉老版本
		$ git branch -d tmp	// 再把临时的tmp分支给删除掉

- `git pull`命令，相当于`git fetch`和`git merge`

		$ git pull origin master // 相当于从远程仓库获取最新版本并merge到本地

当然，上述命令中，`git fetch`更安全一些，因为我们可以查看更新情况，然后再决定是否合并。

### 9、查看版本信息，版本回退

`git log`命令可以显示从最近到最远的提交日志，也可以加上`--pretty=oneline`参数来简化输出信息的显示。

	$ git log --pretty=oneline
	3628164fb26d48395383f8f31179f24e0882e1e0 append GPL
	ea34578d5496d7dd233c827ed32a8cd576c5ee85 add distributed
	cb926e7ea50ad11b8f9e909c05226233bf755030 wrote a readme file
其中，一大串数字表示的是`commit id`（版本号）。在Git中，用`HEAD`来表示当前版本，上一个版本是`HEAD^`,上上一个版本就是`HEAD^^`,再往上100个版本就写成`HEAD~100`，相当于指针一样。

通过一下命令可以退回到任意版本：
	
	$ git reset --hard HEAD^ // 用相对的commit版本。
	$ git reset --hard 3628164  // 指定commit号就可以。

如果想吃后悔药，就用命令`git reflog`记录git的每一次命令，就可以找到相应的commit号，重返版本。

### 10、工作区和暂存区

- **工作区（Working Directory）：**就是在电脑里面能看到的目录，比如`learngit`文件夹就是一个工作区。
- **版本库（Repository）：**里面有一个隐藏目录`.git`，不算是工作区，而算是Git的版本库。而其中版本库里最重要的是被称之为`stage`的暂存区，还有Git为我们自动创建爱你的第一个分支`master`。

	![](http://ootah442n.bkt.clouddn.com/stage.jpg)

我们把文件往Git版本库里添加的时候，是分两步执行的：

第一步是用`git add`将文件添加进去，实际上就是把文件修改添加进暂存区（Stage）；

第二步是用`git commit`提交更改，实际上就是把暂存区的所有内容提交到当前的分区。（一次性提交暂存区的所有修改）
 
### 11、管理修改

下面两种方式来提交修改都OK。

- 第一次修改 -> git add -> 第二次修改 -> git commit
- 第一次修改 -> git add -> 第二次修改 -> git add -> git commit

### 12、撤销修改

-  **撤销工作区的修改**

	`git checkout -- file`命令来实现，把相应的文件在工作区的修改全部撤销，有两种情况：

	一种是`readme.txt`自修改后还没放到暂存区，撤销修改就回到和版本库一模一样的状态；

	一种是`readme.txt`已经添加到暂存区后，又做了修改，现在，撤销修改就回到添加到暂存区后的状态。

	总之，就是将这个文件回到最近一次`git commit`或者`git add`时的状态。其中`--`很关键，没有的话就变成另外一个命令了。

- **撤销了stage到暂存区的文件**
	
	另外，当我们要撤销掉（unstage）暂存区里的修改时候，可以将暂存区的修改回退到工作区。当我们用`HEAD`时，表示最新的版本。

		git reset HEAD readme.txt

### 13、删除文件

	$ git rm test.txt
	$ git commit -m `remove test.txt` 

同样能够达到之前管理修改的作用，对于删除文件来说。

如果误删了而文件，那么不用着急，因为版本库里面还有，可以通过：

	$ git checkout -- test.txt

`git checkout`其实就是用版本库里面的版本替换掉工作区的版本，无论工作区还是修改还是删除，都可以"一键还原"。
