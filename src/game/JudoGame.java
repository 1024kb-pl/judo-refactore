package game;

import enity.Player;
import enity.Score;
import javafx.application.Platform;
import javafx.scene.input.MouseButton;

import javax.swing.Timer;

public class JudoGame
{
    private Player whitePlayer;
    private Player bluePlayer;
    private int secondOsaekomi;
    private int secondFight;
    private int minuteFight;
    private boolean stateFightTime;
    private boolean stateGoldenScore;

    public JudoGame()
    {
        this.whitePlayer = new Player();
        this.bluePlayer = new Player();
        this.secondOsaekomi = 0;
        this.secondFight = 0;
        this.minuteFight = 4;
        this.stateFightTime = false;
        this.stateGoldenScore = false;
    }

    public void addBlueScoreShido()
    {
        addScoreShido(bluePlayer);
    }

    public void removeBlueScoreShido()
    {
        removeScoreShido(bluePlayer);
    }

    public void addBlueScoreWazaari()
    {
        addScoreWazaari(bluePlayer);
    }

    public void removeBlueScoreWazaari()
    {
        removeScoreWazaari(bluePlayer);
    }

    public void addBlueScoreIppon()
    {
        addScoreIppon(bluePlayer);
    }

    public void removeBlueScoreIppon()
    {
        removeScoreIppon(bluePlayer);
    }

    public void addWhiteScoreShido()
    {
        addScoreShido(whitePlayer);
    }

    public void removeWhiteScoreShido()
    {
        removeScoreShido(whitePlayer);
    }

    public void addWhiteScoreWazaari()
    {
        addScoreWazaari(whitePlayer);
    }

    public void removeWhiteScoreWazaari()
    {
        removeScoreWazaari(whitePlayer);
    }

    public void addWhiteScoreIppon()
    {
        addScoreIppon(whitePlayer);
    }

    public void removeWhiteScoreIppon()
    {
        removeScoreIppon(whitePlayer);
    }

    private void addScoreShido(Player player)
    {
        final Score playerScore = player.getScore();
        final int scoreShido = playerScore.getScoreShido();
        switch (scoreShido) {
            case 0:
                playerScore.setScoreShido(1);
                break;
            case 1:
                playerScore.setScoreShido(2);
                break;
            case 2:
                playerScore.setScoreShido(3);
                playerScore.setScoreIppon(1);
                break;
        }
    }

    private void removeScoreShido(Player player)
    {
        final Score playerScore = player.getScore();
        final int scoreShido = playerScore.getScoreShido();

        switch (scoreShido) {
            case 1:
                playerScore.setScoreShido(0);
                break;
            case 2:
                playerScore.setScoreShido(1);
                break;
            case 3:
                playerScore.setScoreIppon(0);
                playerScore.setScoreShido(2);
                break;
        }
    }

    private void addScoreWazaari(Player player)
    {
        final Score playerScore = player.getScore();
        final int scoreWazaari = playerScore.getScoreWazaari();

        switch (scoreWazaari) {
            case 0:
                playerScore.setScoreWazaari(1);
                break;
            case 1:
                playerScore.setScoreWazaari(2);
                playerScore.setScoreIppon(1);
                break;
        }
    }

    private void removeScoreWazaari(Player player)
    {
        final Score playerScore = player.getScore();
        final int scoreWazaari = playerScore.getScoreWazaari();

        switch (scoreWazaari) {
            case 1:
                playerScore.setScoreWazaari(0);
                break;
            case 2:
                playerScore.setScoreWazaari(1);
                playerScore.setScoreIppon(0);
                break;
        }
    }

    private void addScoreIppon(Player player)
    {
        final Score playerScore = player.getScore();
        final int scoreIppon = playerScore.getScoreIppon();
        switch (scoreIppon) {
            case 0:
                playerScore.setScoreIppon(1);
                break;
        }
    }

    private void removeScoreIppon(Player player)
    {
        final Score playerScore = player.getScore();
        final int scoreIppon = playerScore.getScoreIppon();
        final int scoreWazaari = playerScore.getScoreWazaari();
        final int scoreShido = playerScore.getScoreShido();

        if(scoreIppon  == 1)
        {
            if(scoreWazaari == 2)
            {
                playerScore.setScoreWazaari(1);
                playerScore.setScoreIppon(0);
            }

            else if(scoreShido == 3)
            {
                playerScore.setScoreShido(2);
                playerScore.setScoreIppon(0);
            }

            else
            {
                playerScore.setScoreIppon(0);
            }
        }
    }

    public void startWhiteOsaekomi()
    {
        Platform.runLater(() ->
        {
            {
                secondOsaekomi++;

                if(secondOsaekomi == 11)
                {
                    whitePlayer.getScore().setScoreWazaari(1);

                    if(whitePlayer.getScore().getScoreWazaari() == 2)
                    {
                        whitePlayer.getScore().setScoreIppon(1);
                        secondOsaekomi = 0;
                    }
                }
                if(secondOsaekomi == 21)
                {
                    whitePlayer.getScore().setScoreIppon(1);
                    secondOsaekomi = 0;

                }
            }
        });
    }

    public void stopWhiteOsaekomi()
    {
        secondOsaekomi = 0;
    }




    /*
    public void startBlueOsaekomi()
    {
        stateBlueOsaekomi = true;

        timerOsaekomi = new Timer(1000, e ->
        {
            if(stateBlueOsaekomi)
            {
                Platform.runLater(() ->
                {
                    {
                        secondOsaekomi++;

                        if(secondOsaekomi == 11)
                        {
                            blueScoreWazaari++;

                            if(blueScoreWazaari == 2)
                            {
                                blueScoreIppon++;
                                stateBlueOsaekomi = false;
                                timerOsaekomi.stop();
                                secondOsaekomi = 0;
                            }
                        }

                        if(secondOsaekomi == 21)
                        {
                            blueScoreIppon++;
                            stateBlueOsaekomi = false;
                            timerOsaekomi.stop();
                            secondOsaekomi = 0;
                        }
                    }
                });

                System.out.println("Second = " + this.getSecondOsaekomi());
            }
        });

        timerOsaekomi.setInitialDelay(0);
        timerOsaekomi.start();
    }

    public void stopBlueOsaekomi()
    {
        stateBlueOsaekomi = false;
        timerOsaekomi.stop();
        secondOsaekomi = 0;
    }
    */

    /*
    public void startFightTime()
    {
        stateFightTime = true;

        timerFight = new Timer(1000, e ->
        {
            if(stateFightTime)
            {
                Platform.runLater(() ->
                {
                    if(secondFight < 10)
                    {
                        secondFight--;
                    }

                    else
                    {
                        secondFight--;
                    }

                    if(minuteFight == 0 && secondFight < 0)
                    {
                        stateFightTime = false;
                        stateGoldenScore = true;
                        minuteFight = 0;
                        secondFight = 0;
                    }

                    if(secondFight < 0)
                    {
                        secondFight = 59;
                        minuteFight--;

                    }
                });

                System.out.println("Minute = " + minuteFight + " Second = " + secondFight);
            }

            if(stateGoldenScore)
            {
                Platform.runLater(() ->
                {
                    if(secondFight < 10)
                    {
                        secondFight++;
                    }

                    else
                    {
                        secondFight++;
                    }

                    if(secondFight > 59)
                    {
                        secondFight = 0;
                        minuteFight++;
                    }
                });

                System.out.println("Minute = " + minuteFight + " Second = " + secondFight);
            }
        });

        timerFight.setInitialDelay(0);
        timerFight.start();
    }

    public void stopFightTime()
    {
        stateFightTime = false;
        stateGoldenScore = false;

        timerFight.stop();
    }
    */

    public void startGoldenScore()
    {

    }

    public void stopGoldenScore()
    {

    }

    public Player getWhitePlayer()
    {
        return whitePlayer;
    }

    public Player getBluePlayer()
    {
        return bluePlayer;
    }

    public int getMinuteFight()
    {
        return minuteFight;
    }

    public int getSecondFight()
    {
        return secondFight;
    }

    public int getSecondOsaekomi()
    {
        return secondOsaekomi;
    }

    public String onWhiteOsaekomi(boolean isPrimaryClick) {
        if (isPrimaryClick) {

            whitePlayer.setStateOsaekomi(true);
            if(getWhitePlayer().isStateOsaekomi())
            {
                startWhiteOsaekomi();


                if(getSecondOsaekomi() == 11)
                {

                    if(getWhitePlayer().getScore().getScoreWazaari() == 2)
                    {
                        whitePlayer.setStateOsaekomi(false);
                        return "Wazaari2";
                    }

                }

                if(getSecondOsaekomi() == 21)
                {
                    getWhitePlayer().setStateOsaekomi(false);
                    return "Osaekomi21";
                }

            }
        } else {
            whitePlayer.setStateOsaekomi(false);
            stopWhiteOsaekomi();
        }

        return "";
    }

}
