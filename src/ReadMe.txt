数据库创建：
	在hibernate.cfg.xml文件中，修改数据库端口，用户名，密码等信息；
	修改数据库名，并建立database(写项目时使用的是mysql)
	创建表：
		在hibernate.cfg.xml文件中的<session-Factory>标签中
		配置<property name="hibernate.hbm2ddl.auto">create</property>，相应的表信息将自动创建
		在第二次启动服务器时需删除以上<property>标签内容，否则原数据库表中内容将删除而重新建表。
		
	



