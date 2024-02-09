<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<link rel="stylesheet" href="Style.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <meta charset="UTF-8">
    <title>Rock Paper Scissors - Result</title>
   <style>
	    body{
	 		background-image: url("GameImages/Background image/Logo.png");
   	 		background-size: 100%;
		}
        .message {
       		color: rgb(0, 0, 0);
            margin: 5em 0 2em;
            text-align: center;
        }

        .points {
            margin: 2em 0;
            text-align: center;
        }

        .computerPoints {
            margin-left: 3em;
        }

        .playerPoints {
            margin-right: 3em;
        }

        .options {
            margin-top: 5em;
            display: flex;
            justify-content: space-around;
        }

        .options button {
   			 background: none;
    		 color: rgb(0, 0, 0);
    		 font-family: "Comic Sans MS";
   			 border: 1px solid #fff;
  			 padding: 1em 2em;
   			 border-radius: 7px;
   			 width: 150px;
   			 white-space: nowrap;
   			 cursor: pointer;
   			 outline: none;
   			 transition: 0.2s all linear;
		}
		.options button:hover {
   			 background-color: darkcyan;
   			 border: 1px solid darkcyan;
		}
		.result{
			font-size: 15px;
		    font-family:"Comic Sans MS";
		}
</style>
</head>
<body>
<div class="message">
        <div class="result" align="center" >
        <p>Computer Points	: <span class="computerPoints">${computerPoints}</span></p>
        <p>Player Points	: <span class="playerPoints">${playerPoints}</span></p>
        <script type="text/javascript">
          if (${computerPoints}==${playerPoints}) {
            document.write("Result: It's a draw!");
        } else if (${playerPoints}>${computerPoints}) {
        	 document.write("Result: Congratulations You win!");
        } else {
        	 document.write("Result: Computer wins!");
        }
          </script>
          
 <div class="options">
        <a href=index.jsp><button type="button" onclick="GoToIndex">Try Again</button></a> 
            </div>

</div>
</div>
</body>
</html>
