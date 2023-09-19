<script>
    export default {
        data() {
            return {

            }
        }
    }
</script>

<template>
    <div id="gameboard">
        <span class="playerscores">
            <div id="player1score">Player 1: </div> 
            <div id="player2score">Player 2: </div> 
            <div id="player3score">Player 3: </div>
        </span>
        <br/>
        <table id="board">   
            <caption style="color:black"> Jeopardy!</caption>     
            <tr class="boardrow">
                <th id="category1">{{cat1}}</th>
                <th id="category2">{{cat2}}</th>
                <th id="category3">{{cat3}}</th>
                <th id="category4">{{cat4}}</th>
            </tr>
            <tr>
                <td>$100</td>
                <td>$100</td>
                <td>$100</td>
                <td>$100</td>
            </tr>
            <tr>
                <td>$200</td>
                <td>$200</td>
                <td>$200</td>
                <td>$200</td>
            </tr>
            <tr>
                <td>$300</td>
                <td>$300</td>
                <td>$300</td>
                <td>$300</td>
            </tr>
            <tr>
                <td>$400</td>
                <td>$400</td>
                <td>$400</td>
                <td>$400</td>
            </tr>
            <tr>
                <td>$500</td>
                <td>$500</td>
                <td>$500</td>
                <td>$500</td>
            </tr>
        </table> 
        <br/>
        <h4>Category: </h4> <br/>
        <h4>Value: </h4> <br/>
        <h4>Question: </h4> <br/>
        <div><button>True</button> <button>False</button></div>
    </div>
</template>

<style>
#gameboard {
    
}
table, th, td {
  border: 2px solid black;
  font-family:'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Arial, sans-serif;
  font-size:x-large;
  background-color: blue;
  color:yellow;
  
}
.playerscores {
    font-family:'Trebuchet MS', 'Lucida Sans Unicode', 'Lucida Grande', 'Lucida Sans', Arial, sans-serif;
    font-size:large;
}


</style>