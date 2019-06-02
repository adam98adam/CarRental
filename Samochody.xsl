<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">
<html> 
<body>
  <h1>Wypozyczalnia Samochodow !!!</h1>
  <h2>Samochody : </h2>
  <table border="1">
    <tr bgcolor="#9acd32">
      <th style="text-align:left">Typ</th>
      <th style="text-align:left">Marka</th>
      <th style="text-align:left">Model</th>
      <th style="text-align:left">Kolor</th>
      <th style="text-align:left">Skrzynia Biegow</th>
      <th style="text-align:left">Paliwo</th>


    </tr>
    <xsl:for-each select="wypozyczalniaSamochodow/samochody/samochod">
		<xsl:if test="kolor='Niebieski'">
			<tr bgcolor="blue">
				<td><xsl:value-of select="typ"/></td>
      				<td><xsl:value-of select="marka"/></td>
      				 <td><xsl:value-of select="model"/></td>
       				 <td><xsl:value-of select="kolor"/></td>
                                 <td><xsl:value-of select="skrzyniaBiegow"/></td>
                                 <td><xsl:value-of select="paliwo"/></td>
			</tr>
		</xsl:if>
		<xsl:if  test="kolor='Bialy'">
			<tr bgcolor="white">
				<td><xsl:value-of select="typ"/></td>
      				<td><xsl:value-of select="marka"/></td>
      				<td><xsl:value-of select="model"/></td>
       				<td><xsl:value-of select="kolor"/></td>
                                <td><xsl:value-of select="skrzyniaBiegow"/></td>
                                <td><xsl:value-of select="paliwo"/></td>
			</tr>
		</xsl:if>
		<xsl:if test="kolor='Czarny'">
			<tr bgcolor="black" style="color:red" >
				<td><xsl:value-of select="typ"/></td>
      				<td><xsl:value-of select="marka"/></td>
      				<td><xsl:value-of select="model"/></td>
       				<td><xsl:value-of select="kolor"/></td>
                                <td><xsl:value-of select="skrzyniaBiegow"/></td>
                                <td><xsl:value-of select="paliwo"/></td>
			</tr>
		</xsl:if>
		<xsl:if test="kolor='Czerwony'">
			<tr bgcolor="red">
				<td><xsl:value-of select="typ"/></td>
      				<td><xsl:value-of select="marka"/></td>
      				 <td><xsl:value-of select="model"/></td>
       				 <td><xsl:value-of select="kolor"/></td>
                                 <td><xsl:value-of select="skrzyniaBiegow"/></td>
                                 <td><xsl:value-of select="paliwo"/></td>
			</tr>
		</xsl:if>
		<xsl:if test="kolor='Srebrny'">
			<tr bgcolor="#COC0C0">
				<td><xsl:value-of select="typ"/></td>
      				<td><xsl:value-of select="marka"/></td>
      				 <td><xsl:value-of select="model"/></td>
       				 <td><xsl:value-of select="kolor"/></td>
                                 <td><xsl:value-of select="skrzyniaBiegow"/></td>
                                 <td><xsl:value-of select="paliwo"/></td>
			</tr>
		</xsl:if>
		<xsl:if test="kolor='Fioletowy'">
			<tr bgcolor="#800080">
				<td><xsl:value-of select="typ"/></td>
      				<td><xsl:value-of select="marka"/></td>
      				 <td><xsl:value-of select="model"/></td>
       				 <td><xsl:value-of select="kolor"/></td>
                                 <td><xsl:value-of select="skrzyniaBiegow"/></td>
                                 <td><xsl:value-of select="paliwo"/></td>
			</tr>
		</xsl:if>
		<xsl:if test="koloe='Zolty'">
			<tr bgcolor="#FFFF00">
				<td><xsl:value-of select="typ"/></td>
      				<td><xsl:value-of select="marka"/></td>
      				 <td><xsl:value-of select="model"/></td>
       				 <td><xsl:value-of select="kolor"/></td>
                                 <td><xsl:value-of select="skrzyniaBiegow"/></td>
                                 <td><xsl:value-of select="paliwo"/></td>
			</tr>
		</xsl:if>


    </xsl:for-each>
  </table>
<h2>Cennik : </h2>
	<table>
		<tr>
			<th>Typ</th>
			<th>Dzien</th>
			<th>Tydzien</th>
			<th>Miesiac</th>
		</tr>
	</table>
		<ol>
		<xsl:for-each select="wypozyczalniaSamochodow/cennik/cena">
			<xsl:sort select="dzien"/>
			<li>
			<xsl:choose>
				<xsl:when test="dzien &lt; 270">
					<td style="color:red"><b><xsl:value-of select="@typ"/></b></td>
					<td style="color:red"><u><xsl:value-of select="dzien"/></u></td>
					<td style="color:red"><u><xsl:value-of select="tydzien"/></u></td>
					<td style="color:red"><u><xsl:value-of select="miesiac"/></u></td>
				</xsl:when>
				<xsl:otherwise>
					<td style="color:blue"><b><xsl:value-of select="@typ"/></b></td>
					<td style="color:blue"><u><xsl:value-of select="dzien"/></u></td>
					<td style="color:blue"><u><xsl:value-of select="tydzien"/></u></td>
					<td style="color:blue"><u><xsl:value-of select="miesiac"/></u></td>
				</xsl:otherwise>
			</xsl:choose>
			</li>
		</xsl:for-each>
	</ol>
</body>
</html>
</xsl:template>
</xsl:stylesheet>


