//package com.pack.stonepaprescissor;

//import java.io.IOException;
//import java.util.Random;
//
//import jakarta.servlet.RequestDispatcher;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.annotation.WebServlet;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.servlet.http.HttpSession;

//@WebServlet(urlPatterns = "/GameServlet", name = "GameServlet")
//public class GameServlet extends HttpServlet {
//    private static final long serialVersionUID = 1L;
//
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        String userChoice = request.getParameter("userChoice");
//
//        // Retrieve or initialize points from the session
//        HttpSession session = request.getSession();
//        Integer computerPoints = (Integer) session.getAttribute("computerPoints");
//        Integer playerPoints = (Integer) session.getAttribute("playerPoints");
//
//        // Initialize points if not present in the session
//        if (computerPoints == null) {
//            computerPoints = 0;
//        }
//        if (playerPoints == null) {
//            playerPoints = 0;
//        }
//
//        // Implement the game logic
//        String[] choices = { "STONE", "PAPER", "SCISSORS" };
//        Random random = new Random();
//        int computerIndex = random.nextInt(choices.length);
//        String computerChoice = choices[computerIndex];
//
//        // Compare user's choice with computer's choice and update points
//        if (userChoice.equals("STONE")) {
//            if (computerChoice.equals("PAPER")) {
//                computerPoints++;
//            } else if (computerChoice.equals("SCISSORS")) {
//                playerPoints++;
//            }
//        } else if (userChoice.equals("PAPER")) {
//            if (computerChoice.equals("SCISSORS")) {
//                computerPoints++;
//            } else if (computerChoice.equals("STONE")) {
//                playerPoints++;
//            }
//        } else if (userChoice.equals("SCISSORS")) {
//            if (computerChoice.equals("STONE")) {
//                computerPoints++;
//            } else if (computerChoice.equals("PAPER")) {
//                playerPoints++;
//            }
//        }
//
//        // Update points in the session
//        session.setAttribute("computerPoints", computerPoints);
//        session.setAttribute("playerPoints", playerPoints);
//
//        // Prepare the response data
//        GameResult gameResult = determineGameResult(userChoice, computerChoice);
//        request.setAttribute("computerPoints", computerPoints);
//        request.setAttribute("playerPoints", playerPoints);
//        request.setAttribute("result", gameResult.getResult());
//
//        // Forward to the Result.jsp page
//        request.getRequestDispatcher("Result.jsp").forward(request, response);
//    }
//
//    private GameResult determineGameResult(String userChoice, String computerChoice) {
//        if (userChoice.equals(computerChoice)) {
//            return new GameResult("It's a draw!");
//        } else if ((userChoice.equals("STONE") && computerChoice.equals("SCISSORS"))
//                || (userChoice.equals("PAPER") && computerChoice.equals("STONE"))
//                || (userChoice.equals("SCISSORS") && computerChoice.equals("PAPER"))) {
//            return new GameResult("You win!");
//        } else {
//            return new GameResult("Computer wins!");
//        }
//    }
//
//    private static class GameResult {
//        private final String result;
//
//        public GameResult(String result) {
//            this.result = result;
//        }
//
//        public String getResult() {
//            return result;
//        }
//    }
//}






//
//
//@WebServlet(urlPatterns = "/GameServlet", name = "GameServlet")
//public class GameServlet extends HttpServlet {
//    private static final long serialVersionUID = 1L;
//
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        String userChoice = request.getParameter("userChoice");
//
//        // Retrieve or initialize points from the session
//        HttpSession session = request.getSession();
//        Integer computerPoints = (Integer) session.getAttribute("computerPoints");
//        Integer playerPoints = (Integer) session.getAttribute("playerPoints");
//
//        // Initialize points if not present in the session
//        if (computerPoints == null) {
//            computerPoints = 0;
//        }
//        if (playerPoints == null) {
//            playerPoints = 0;
//        }
//
//        // Implement the game logic
//        String[] choices = { "STONE", "PAPER", "SCISSORS" };
//        Random random = new Random();
//        int computerIndex = random.nextInt(choices.length);
//        String computerChoice = choices[computerIndex];
//
//        // Compare user's choice with computer's choice and update points
//        if (userChoice.equals("STONE")) {
//            if (computerChoice.equals("PAPER")) {
//                computerPoints++;
//            } else if (computerChoice.equals("SCISSORS")) {
//                playerPoints++;
//            }
//        } else if (userChoice.equals("PAPER")) {
//            if (computerChoice.equals("SCISSORS")) {
//                computerPoints++;
//            } else if (computerChoice.equals("STONE")) {
//                playerPoints++;
//            }
//        } else if (userChoice.equals("SCISSORS")) {
//            if (computerChoice.equals("STONE")) {
//                computerPoints++;
//            } else if (computerChoice.equals("PAPER")) {
//                playerPoints++;
//            }
//        }
//
//        // Update points in the session
//        session.setAttribute("computerPoints", computerPoints);
//        session.setAttribute("playerPoints", playerPoints);
//
//        // Determine the game result
//        String result = determineGameResult(userChoice, computerChoice);
//
//        // Set attributes in the request
//        request.setAttribute("computerPoints", computerPoints);
//        request.setAttribute("playerPoints", playerPoints);
//        request.setAttribute("result", result);
//
//        // Forward to the Result.jsp page
//        RequestDispatcher dispatcher = request.getRequestDispatcher("Result.jsp");
//        dispatcher.forward(request, response);
//    }
//
//    private String determineGameResult(String userChoice, String computerChoice) {
//        if (userChoice.equals(computerChoice)) {
//            return "It's a draw!";
//        } else if ((userChoice.equals("STONE") && computerChoice.equals("SCISSORS"))
//                || (userChoice.equals("PAPER") && computerChoice.equals("STONE"))
//                || (userChoice.equals("SCISSORS") && computerChoice.equals("PAPER"))) {
//            return "You win!";
//        } else {
//            return "Computer wins!";
//        }
//    }
//}




package com.pack.stonepaprescissor;

import java.io.IOException;
import java.util.Random;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet(urlPatterns = "/GameServlet", name = "GameServlet")
public class GameServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userChoice = request.getParameter("userChoice");

        // Retrieve or initialize points from the session
        HttpSession session = request.getSession();
        Integer computerPoints = (Integer) session.getAttribute("computerPoints");
        Integer playerPoints = (Integer) session.getAttribute("playerPoints");

        // Initialize points if not present in the session
        if (computerPoints == null) {
            computerPoints = 0;
        }
        if (playerPoints == null) {
            playerPoints = 0;
        }

        // Implement the game logic
        String[] choices = {"STONE", "PAPER", "SCISSORS"};
        Random random = new Random();
        int computerIndex = random.nextInt(choices.length);
        String computerChoice = choices[computerIndex];

        // Compare user's choice with computer's choice and update points
        if (userChoice.equals("STONE")) {
            if (computerChoice.equals("PAPER")) {
                computerPoints++;
            } else if (computerChoice.equals("SCISSORS")) {
                playerPoints++;
            }
        } else if (userChoice.equals("PAPER")) {
            if (computerChoice.equals("SCISSORS")) {
                computerPoints++;
            } else if (computerChoice.equals("STONE")) {
                playerPoints++;
            }
        } else if (userChoice.equals("SCISSORS")) {
            if (computerChoice.equals("STONE")) {
                computerPoints++;
            } else if (computerChoice.equals("PAPER")) {
                playerPoints++;
            }
        }

        // Update points in the session
        session.setAttribute("computerPoints", computerPoints);
        session.setAttribute("playerPoints", playerPoints);

        // Determine the game result
        GameResult gameResult = determineGameResult(userChoice, computerChoice);

        // Set attributes for computerPoints, playerPoints, and gameResult
        request.setAttribute("computerPoints", computerPoints);
        request.setAttribute("playerPoints", playerPoints);
        request.setAttribute("gameResult", gameResult);

        // Forward to the Result.jsp page
        request.getRequestDispatcher("Result.jsp").forward(request, response);
    }

    private GameResult determineGameResult(String userChoice, String computerChoice) {
        if (userChoice.equals(computerChoice)) {
            return new GameResult("It's a draw!");
        } else if ((userChoice.equals("STONE") && computerChoice.equals("SCISSORS"))
                || (userChoice.equals("PAPER") && computerChoice.equals("STONE"))
                || (userChoice.equals("SCISSORS") && computerChoice.equals("PAPER"))) {
            return new GameResult("You win!");
        } else {
            return new GameResult("Computer wins!");
        }
    }

    public static class GameResult {
        private final String result;

        public GameResult(String result) {
            this.result = result;
        }

        public String getResult() {
            return result;
        }
    }
}
