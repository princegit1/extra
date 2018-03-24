<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:param name="doc" />
	<xsl:template match="/">
		<table>
			<!-- <tr> <th>ID</th> <th>Name</th> </tr> -->
			<xsl:for-each select="default/stryroot/stry">
				<tr>
					<td>
						<xsl:value-of select="msid"></xsl:value-of>
					</td>
					<!-- <td> <xsl:value-of select="stname"></xsl:value-of> </td> -->
					<td>
						<xsl:value-of select="trimmedtitle"></xsl:value-of>
					</td>
					<td>
						<xsl:value-of select="cmsassoc/image/imgname"></xsl:value-of>
					</td>
					<td>
						<xsl:value-of select="seolocation"></xsl:value-of>
					</td>
				</tr>
			</xsl:for-each>
		</table>
	</xsl:template>
</xsl:stylesheet>   
 