<?xml version="1.0" encoding="UTF-8" ?>
<!--=========================================================================-->
<!--  Copyright bj 2015 All Rights Reserved. -->
<!--  @version	1.00												 -->
<!--=========================================================================-->

<sqlList>
 	<!--取得文件最大序号-->
 	<sql sqlId="key.files.getMaxOrd">
	<![CDATA[
	select nvl(max(F_ORD), 0) + 1
	  from S_FILES
	 where 1=1
	   and DATA_ID = #{dataId}
	   and d_Type = #{dType}
	   and F_DEL = 0
	]]>
 	</sql>
 	
 	<!--取得文件
 	    ID,D_TB_NM,D_TYPE,DATA_ID,F_NAME,F_PATH,F_SURFIX,F_ORD,F_DEL
 	-->
 	<sql sqlId="key.files.getfiles">
	<![CDATA[
	select ID,F_NAME,F_PATH,F_SURFIX,F_ORD
	  from S_FILES
	 where F_DEL = 0--是否删除
	   [and ID = #{id}]
	   [and DATA_ID = #{dataId}]--数据ID
	   [and D_TYPE = #{dType}]--业务类型
	   [and F_NAME like '%'||#{fName}||'%']--名称
	   [and F_PATH like '%'||#{fPath}||'%']--存储地址
	   [and F_ORD = #{fOrd}]--序号
	   [and F_SURFIX = #{fSurfix}]--文件后缀
	   order by F_ORD
	]]>
 	</sql>

</sqlList>
