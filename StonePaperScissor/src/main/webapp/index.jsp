<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Rock Paper Scissors</title>
     <style>
       body{
	 background-image: url("GameImages/Background image/Logo.png");
   	 background-size: 100%;
	}
        .message {
            margin: 5em 0 2em;
            text-align: center;
        }

        .images {
            display: flex;
            justify-content: space-around;
            align-items: center;
            text-align: center;
            height: 200px;
        }

        .computer img,
        .player img {
            width: 75%;
        }

        .shakeComputer {
            animation: shakeComputer 0.8s linear;
        }

        .shakePlayer {
            animation: shakePlayer 0.8s linear;
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

        .shakeComputer, .shakePlayer {
            animation: shake 0.8s linear;
        }

        @keyframes shake {
            0% {
                transform: rotate(-30deg);
            }
            25% {
                transform: rotate(30deg);
            }
            50% {
                transform: rotate(-30deg);
            }
            75% {
                transform: rotate(30deg);
            }
            100% {
                transform: rotate(0deg);
            }
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="message">CHOOSE AN OPTION</div>
        <div class="images">
            <div class="computer">
                <img src="GameImages/stoneComputer.png" alt="Computer Image" />
            </div>
            <div class="player">
                <img src="GameImages/stonePlayer.png" alt="Player Image" />
            </div>
        </div>
     <div class="points">
            COMPUTER <span class="computerPoints">  </span> / <span class="playerPoints"></span> PLAYER
        </div>
        <div class="options">
            <button type="button" onclick="play('STONE')">STONE</button>
            <button type="button" onclick="play('PAPER')">PAPER</button>
            <button type="button" onclick="play('SCISSORS')">SCISSORS</button>
            <button type="button" onclick="goToResult()">Go To Result</button>
        </div>

    </div>

    <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script> 
  
 
    <script>
    const computer = document.querySelector(".computer img");
    const player = document.querySelector(".player img");
    const computerPointsDisplay = document.querySelector(".computerPoints");
    const playerPointsDisplay = document.querySelector(".playerPoints");

    function play(userChoice) {
        $.post("GameServlet", { userChoice: userChoice })
            .done(function(result) {
                console.log(result);

                updateUI(result);

                animateImages(userChoice, result.computerChoice);
            })
            .fail(function() {
                console.error("Error in the POST request");
            });
    }
    function animateComputerImage(computerChoice) {
        console.log("computerChoice:", computerChoice); // Log the value to check if it's undefined
        computer.src = "GameImages/" + computerChoice.toLowerCase() + "Computer.png";
    }



    function animateImages(userChoice, computerChoice) {
        computer.classList.add("shakeComputer");
        player.classList.add("shakePlayer");

        setTimeout(() => {
            computer.classList.remove("shakeComputer");
            player.classList.remove("shakePlayer");

            player.src = "GameImages/" + userChoice.toLowerCase() + "Player.png";
            animateComputerImage(computerChoice);
        }, 900);
    }
    
    function updateUI(result) {
        computerPointsDisplay.textContent = result.computerPoints;
        playerPointsDisplay.textContent = result.playerPoints;
    }

    function goToResult() {
        window.location.href = "Result.jsp";
    }
</script>
</body>
</html>