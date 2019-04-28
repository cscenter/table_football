<#-- @ftlvariable name="data" type="com.kicker.Enteties.Games" -->
<html>
<body>
<ul>
    <#list data.items>
    <table>
        <#items as game>
            <tr>
                    <td>Game ${game?counter}</td>

                    <#if !(game.startTime??)>
                    <td>
                        <a href="/startGame?_id=${game._id}" class="btn btn-danger float-right mr-2" role="button">Start</a>
                    </td>
                    </#if>

                    <#if game.startTime??>
                        <#if !(game.endTime??)>
                        <td>
                            <a href="/endGame?_id=${game._id}" class="btn btn-danger float-right mr-2" role="button">End</a>
                        </td>
                        </#if>
                    </#if>

                    <#if game.teamRed??>
                        <#if game.teamRed?size < 2>
                        <td>
                            <a href="/joinRed?_id=${game._id}" class="btn btn-danger float-right mr-2" role="button">Join Red</a>
                        </td>
                        </#if>
                    </#if>

                    <#if game.teamBlue??>
                        <#if game.teamBlue?size < 2>
                            <td>
                                <a href="/joinBlue?_id=${game._id}" class="btn btn-danger float-right mr-2" role="button">Join Blue</a>
                            </td>
                        </#if>
                    </#if>
            </tr>
        </#items>
    </table>
</#list>
</ul>
</body>
</html>