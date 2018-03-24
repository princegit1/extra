<?xml version="1.0"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	version="1.0">

	<xsl:param name="bgColor1" />
	<xsl:param name="bgColor2" />   
	<xsl:template match="/">
		<html>
			<body>
				<h2>Details</h2>

				<table border="1" bgColor="{$bgColor1}">
					<tr>
						<td>Name</td>
						<td>Class</td>
						<td>Roll No</td>
					</tr>

					<xsl:for-each select="students/student">
						<tr bgcolor="{$bgColor2}">
							<td>
								<xsl:value-of select="name"></xsl:value-of>
							</td>
							<td>
								<xsl:value-of select="class"></xsl:value-of>
							</td>
							<td>
								<xsl:value-of select="rollno"></xsl:value-of>
							</td>
						</tr>
					</xsl:for-each>

				</table>
			</body>
		</html>

	</xsl:template>
</xsl:stylesheet>