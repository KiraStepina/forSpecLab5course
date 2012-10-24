<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">
        <html>
            <body>
                <h2>Contacts</h2>
                <table>
                    <tr>
                        <td>
                            Name
                        </td>
                        <td>
                            Address
                        </td>
                        <td>
                            Telephone
                        </td>
                    </tr>
                    <xsl:apply-templates/>
                    <tr>
                        <td colspan="3">
                            <div style="display:inline-block">
                                <form action="list">
                                    <input type="hidden" name="direction" value="first"/>
                                    <button type="submit">First</button>
                                </form>
                            </div>
                            <div style="display:inline-block">
                                <form action="list">
                                    <input type="hidden" name="direction" value="prev"/>
                                    <button type="submit">Previous</button>
                                </form>
                            </div>
                            <div style="display:inline-block">
                                <form action="list">
                                    <input type="hidden" name="direction" value="next"/>
                                    <button type="submit">Next</button>
                                </form>
                            </div>
                            <div style="display:inline-block">
                                <form action="list">
                                    <input type="hidden" name="direction" value="last"/>
                                    <button type="submit">Last</button>
                                </form>
                            </div>
                            <div style="display:block">
                                <a href="/">Register again</a>
                            </div>
                        </td>
                    </tr>
                </table>
            </body>
        </html>
    </xsl:template>

    <xsl:template match="client">
        <p>
            <tr>
                <xsl:apply-templates select="name"/>
                <xsl:apply-templates select="address"/>
                <xsl:apply-templates select="telephone"/>
            </tr>
        </p>
    </xsl:template>

    <xsl:template match="name">
        <td>

            <span style="color:#ff0000">
                <xsl:value-of select="."/>
            </span>
            <br/>
        </td>
    </xsl:template>
    <xsl:template match="address">
        <td>

            <span style="color:#00ff00">
                <xsl:value-of select="."/>
            </span>
            <br/>
        </td>
    </xsl:template>
    <xsl:template match="telephone">
        <td>

            <span style="color:#0000ff">
                <xsl:value-of select="."/>
            </span>
            <br/>
        </td>
    </xsl:template>

</xsl:stylesheet>