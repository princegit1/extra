 ${list }
<%@ taglib uri="/struts-tags" prefix="s"%>
<s:form>
	<s:iterator value="list">
		<s:property value="id" /> -- <s:property value="name" />
	</s:iterator>

</s:form>
