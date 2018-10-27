package sample;

import game.JudoGame;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import javax.swing.*;

public class Controller //implements ActionListener
{
    /*
    private Timer timer;
    private Timer timer2;
    private static boolean stateWhiteOsaekomi = false;
    private static boolean stateFightTime = false;
    private static boolean stateGoldenScore = false;
    private static int secondOsaekomi = 0;
    private static int secondFight = 0;
    private static int minuteFight = 4;
    private static int whiteScoreWazaari = 0;
    private static int whiteScoreIppon = 0;
    private static int whiteScoreShido = 0;
    private static int blueScoreWazaari = 0;
    private static int blueScoreIppon = 0;
    private static int blueScoreShido = 0;
    */

    private JudoGame judoGame = new JudoGame();
    private Timer timerFightTime;
    private Timer timerOsaekomi;

    @FXML private Label whiteOsaekomi;
    @FXML private Label whiteIppon;
    @FXML private Label whiteWazaari;
    @FXML private Label whiteShido;
    @FXML private Label blueOsaekomi;
    @FXML private Label blueIppon;
    @FXML private Label blueWazaari;
    @FXML private Label blueShido;
    @FXML private Label fightTime;

    @FXML
    public void initialize()
    {
        whiteOsaekomi.setText("" + judoGame.getSecondOsaekomi());
        whiteOsaekomi.setTextFill(Color.WHITE);
        whiteIppon.setText("" + judoGame.getWhitePlayer().getScore().getScoreIppon());
        whiteIppon.setTextFill(Color.WHITE);
        whiteWazaari.setText("" + judoGame.getWhitePlayer().getScore().getScoreWazaari());
        blueOsaekomi.setText("" + judoGame.getSecondOsaekomi());
        blueOsaekomi.setTextFill(Color.BLUE);
        blueIppon.setText("" + judoGame.getBluePlayer().getScore().getScoreIppon());
        blueIppon.setTextFill(Color.BLUE);
        blueWazaari.setText("" + judoGame.getBluePlayer().getScore().getScoreWazaari());
        fightTime.setText("" + judoGame.getMinuteFight() + " : 0" + judoGame.getSecondFight());
        fightTime.setTextFill(Color.RED);
    }

    /*
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(stateWhiteOsaekomi)
        {
            Platform.runLater(() ->
            {
                {
                    whiteOsaekomi.setText("" + secondOsaekomi);
                    secondOsaekomi++;
                    if(secondOsaekomi == 11)
                    {
                        whiteScoreWazaari++;
                        whiteWazaari.setText("1");
                        if(whiteScoreWazaari == 2)
                        {
                            whiteScoreIppon++;
                            whiteIppon.setText("1");
                            whiteIppon.setTextFill(Color.BLACK);
                            stateWhiteOsaekomi = false;
                            timer.stop();
                            secondOsaekomi = 0;
                            whiteOsaekomi.setTextFill(Color.WHITE);
                        }
                    }
                    if(secondOsaekomi == 21)
                    {
                        whiteScoreIppon++;
                        whiteIppon.setText("1");
                        whiteIppon.setTextFill(Color.BLACK);
                        stateWhiteOsaekomi = false;
                        timer.stop();
                        secondOsaekomi = 0;
                        whiteOsaekomi.setTextFill(Color.WHITE);
                    }
                }
            });
            System.out.println("Second = " + secondOsaekomi);
        }
        if(stateFightTime)
        {
            Platform.runLater(() ->
            {
                if(secondFight < 10)
                {
                    fightTime.setText("" + minuteFight + " : 0" + secondFight);
                    secondFight--;
                }
                else
                {
                    fightTime.setText("" + minuteFight + " : " + secondFight);
                    secondFight--;
                }
                if(minuteFight == 0 && secondFight < 0)
                {
                    stateFightTime = false;
                    stateGoldenScore = true;
                    minuteFight = 0;
                    secondFight = 0;
                    fightTime.setText("" + minuteFight + " : 0" + secondFight);
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
                    fightTime.setText("" + minuteFight + " : 0" + secondFight);
                    secondFight++;
                }
                else
                {
                    fightTime.setText("" + minuteFight + " : " + secondFight);
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
    }
    */

    @FXML
    public void mouseClickedWhiteShido(MouseEvent event)
    {
        if(event.getButton().equals(MouseButton.PRIMARY))
        {
            if(judoGame.getWhitePlayer().getScore().getScoreShido() == 0)
            {
                whiteShido.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("image/yellowCard.png"))));
            }

            else if(judoGame.getWhitePlayer().getScore().getScoreShido() == 1)
            {
                whiteShido.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("image/YellowCards.png"))));
            }

            else if(judoGame.getWhitePlayer().getScore().getScoreShido() == 2)
            {
                whiteShido.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("image/redCard.png"))));
                whiteIppon.setTextFill(Color.BLACK);
                whiteIppon.setText("1");
            }

            judoGame.addWhiteScoreShido();
        }

        else if(event.getButton().equals(MouseButton.SECONDARY))
        {
            if(judoGame.getWhitePlayer().getScore().getScoreShido() == 3)
            {
                whiteShido.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("image/YellowCards.png"))));
                whiteIppon.setTextFill(Color.WHITE);
            }

            else if(judoGame.getWhitePlayer().getScore().getScoreShido() == 2)
            {
                whiteShido.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("image/yellowCard.png"))));
            }

            else if(judoGame.getWhitePlayer().getScore().getScoreShido() == 1)
            {
                whiteShido.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("image/whiteCard.png"))));
            }

            judoGame.removeWhiteScoreShido();
        }
    }

    @FXML
    public void mouseClickedWhiteWazaari(MouseEvent event)
    {
        if(event.getButton().equals(MouseButton.PRIMARY))
        {
            if(judoGame.getWhitePlayer().getScore().getScoreWazaari() == 0)
            {
                whiteWazaari.setText("1");
            }

            else if(judoGame.getWhitePlayer().getScore().getScoreWazaari() == 1 )
            {
                whiteIppon.setText("1");
                whiteIppon.setTextFill(Color.BLACK);
            }

            judoGame.addWhiteScoreWazaari();
        }

        else if(event.getButton().equals(MouseButton.SECONDARY))
        {
            if(judoGame.getWhitePlayer().getScore().getScoreWazaari() == 2)
            {
                whiteIppon.setTextFill(Color.WHITE);
            }

            else if(judoGame.getWhitePlayer().getScore().getScoreWazaari() == 1)
            {
                whiteWazaari.setText("0");
            }

            judoGame.removeWhiteScoreWazaari();
        }
    }

    @FXML
    public void mouseClickedWhiteIppon(MouseEvent event)
    {
        if(event.getButton().equals(MouseButton.PRIMARY))
        {
            if(judoGame.getWhitePlayer().getScore().getScoreIppon() == 0)
            {
                whiteIppon.setText("1");
                whiteIppon.setTextFill(Color.BLACK);
            }

            judoGame.addWhiteScoreIppon();
        }

        else if(event.getButton().equals(MouseButton.SECONDARY))
        {
            if (judoGame.getWhitePlayer().getScore().getScoreIppon() == 1)
            {
                if (judoGame.getWhitePlayer().getScore().getScoreWazaari() == 2)
                {
                    whiteIppon.setTextFill(Color.WHITE);
                }

                else if (judoGame.getWhitePlayer().getScore().getScoreShido() == 3)
                {
                    whiteIppon.setTextFill(Color.WHITE);
                    whiteShido.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("image/YellowCards.png"))));
                }

                else
                {
                    whiteIppon.setTextFill(Color.WHITE);
                }
            }

            judoGame.removeWhiteScoreIppon();
        }
    }

    @FXML
    public void mouseClickedWhiteOsaekomi(MouseEvent event) throws InterruptedException // zepsute wyswietlanie !!!
    {
        if(event.getButton().equals(MouseButton.PRIMARY))
        {
            String result = judoGame.onWhiteOsaekomi(true);
            whiteOsaekomi.setTextFill(Color.RED);
            timerOsaekomi = new Timer(1000, e ->
            {
                if (result.equals("wazaari2")) {
                    whiteIppon.setText("1");
                    whiteIppon.setTextFill(Color.BLACK);
                    timerOsaekomi.stop();
                    whiteOsaekomi.setTextFill(Color.WHITE);
                }

                if(result.equals("osaekomi21")) {
                    timerOsaekomi.stop();
                    whiteOsaekomi.setTextFill(Color.WHITE);
                    whiteIppon.setText("1");
                    whiteIppon.setTextFill(Color.BLACK);
                }
            });

            timerOsaekomi.setInitialDelay(0);
            timerOsaekomi.start();
        }

        else if(event.getButton().equals(MouseButton.SECONDARY))
        {
            String result = judoGame.onWhiteOsaekomi(false);
            timerOsaekomi.stop();
            whiteOsaekomi.setTextFill(Color.WHITE);
        }
    }

    @FXML
    public void mouseClickedBlueShido(MouseEvent event)
    {
        if(event.getButton().equals(MouseButton.PRIMARY))
        {
            if(judoGame.getBluePlayer().getScore().getScoreShido() == 0)
            {
                blueShido.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("image/yellowCard.png"))));
            }

            else if(judoGame.getBluePlayer().getScore().getScoreShido() == 1)
            {
                blueShido.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("image/YellowCards2.png"))));
            }

            else if(judoGame.getBluePlayer().getScore().getScoreShido() == 2)
            {
                blueShido.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("image/redCard.png"))));
                blueIppon.setTextFill(Color.WHITE);
                blueIppon.setText("1");
            }

            judoGame.addBlueScoreShido();
        }

        else if(event.getButton().equals(MouseButton.SECONDARY))
        {
            if(judoGame.getBluePlayer().getScore().getScoreShido() == 3)
            {
                blueShido.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("image/YellowCards2.png"))));
                blueIppon.setTextFill(Color.BLUE);
            }

            else if(judoGame.getBluePlayer().getScore().getScoreShido() == 2)
            {
                blueShido.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("image/yellowCard.png"))));
            }

            else if(judoGame.getBluePlayer().getScore().getScoreShido() == 1)
            {
                blueShido.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("image/blueCard.png"))));
            }

            judoGame.removeBlueScoreShido();
        }

    }

    @FXML
    public void mouseClickedBlueWazaari(MouseEvent event)
    {
        if(event.getButton().equals(MouseButton.PRIMARY))
        {
            if(judoGame.getBluePlayer().getScore().getScoreWazaari() == 0)
            {
                blueWazaari.setText("1");
            }

            else if(judoGame.getBluePlayer().getScore().getScoreWazaari() == 1 )
            {
                blueIppon.setText("1");
                blueIppon.setTextFill(Color.WHITE);
            }

            judoGame.addBlueScoreWazaari();
        }

        else if(event.getButton().equals(MouseButton.SECONDARY))
        {
            if(judoGame.getBluePlayer().getScore().getScoreWazaari() == 2)
            {
                blueIppon.setTextFill(Color.BLUE);
            }

            else if(judoGame.getBluePlayer().getScore().getScoreWazaari() == 1)
            {
                blueWazaari.setText("0");
            }

            judoGame.removeBlueScoreWazaari();
        }
    }

    @FXML
    public void mouseClickedBlueIppon(MouseEvent event)
    {
        if(event.getButton().equals(MouseButton.PRIMARY))
        {
            if(judoGame.getBluePlayer().getScore().getScoreIppon() == 0)
            {
                blueIppon.setText("1");
                blueIppon.setTextFill(Color.WHITE);
            }

            judoGame.addBlueScoreIppon();
        }

        else if(event.getButton().equals(MouseButton.SECONDARY))
        {
            if(judoGame.getBluePlayer().getScore().getScoreIppon() == 1)
            {
                if(judoGame.getBluePlayer().getScore().getScoreWazaari() == 2)
                {
                    blueIppon.setTextFill(Color.BLUE);
                }

                else if(judoGame.getBluePlayer().getScore().getScoreShido() == 3)
                {
                    blueIppon.setTextFill(Color.BLUE);
                    blueShido.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("image/YellowCards2.png"))));
                }

                else
                {
                    blueIppon.setTextFill(Color.BLUE);
                }
            }

            judoGame.removeBlueScoreIppon();
        }
    }

    @FXML
    public void mouseClickedBlueOsaekomi(MouseEvent event) throws InterruptedException // zepsute wyswietlanie !!!
    {
        if(event.getButton().equals(MouseButton.PRIMARY))
        {
            /*
            stateWhiteOsaekomi = true;
            whiteOsaekomi.setTextFill(Color.RED);
            timer = new Timer(1000, e ->
            {
                if(stateWhiteOsaekomi)
                {
                    Platform.runLater(() ->
                    {
                        {
                            whiteOsaekomi.setText("" + secondOsaekomi);
                            secondOsaekomi++;
                            if(secondOsaekomi == 11)
                            {
                                whiteScoreWazaari++;
                                whiteWazaari.setText("1");
                                if(whiteScoreWazaari == 2)
                                {
                                    whiteScoreIppon++;
                                    whiteIppon.setText("1");
                                    whiteIppon.setTextFill(Color.BLACK);
                                    stateWhiteOsaekomi = false;
                                    timer.stop();
                                    secondOsaekomi = 0;
                                    whiteOsaekomi.setTextFill(Color.WHITE);
                                }
                            }
                            if(secondOsaekomi == 21)
                            {
                                whiteScoreIppon++;
                                whiteIppon.setText("1");
                                whiteIppon.setTextFill(Color.BLACK);
                                stateWhiteOsaekomi = false;
                                timer.stop();
                                secondOsaekomi = 0;
                                whiteOsaekomi.setTextFill(Color.WHITE);
                            }
                        }
                    });
                    System.out.println("Second = " + secondOsaekomi);
                }
            });
            timer.setInitialDelay(0);
            timer.start();

            judoGame.startBlueOsaekomi();
            blueOsaekomi.setTextFill(Color.RED);

            Platform.runLater(() ->
            {
                blueOsaekomi.setText("" + judoGame.getSecondOsaekomi());

                if(judoGame.getSecondOsaekomi() == 11)
                {
                    blueWazaari.setText("1");

                    if(judoGame.getBlueScoreWazaari() == 2)
                    {
                        blueOsaekomi.setText("1");
                        blueIppon.setTextFill(Color.WHITE);
                        blueOsaekomi.setTextFill(Color.BLUE);
                    }
                }

                if(judoGame.getSecondOsaekomi() == 21)
                {
                    blueIppon.setText("1");
                    blueIppon.setTextFill(Color.WHITE);
                    blueOsaekomi.setTextFill(Color.BLUE);
                }
            });
            */
        }

        else if(event.getButton().equals(MouseButton.SECONDARY))
        {
            /*
            stateWhiteOsaekomi = false;
            timer.stop();
            secondOsaekomi = 0;
            whiteOsaekomi.setTextFill(Color.WHITE);

            blueOsaekomi.setTextFill(Color.BLUE);
            judoGame.stopBlueOsaekomi();
            */
        }
    }

    @FXML
    public void mouseClickedFightTime(MouseEvent event) throws InterruptedException // zepsute wyswietlanie przy stopie dziala !!!
    {
        if(event.getButton().equals(MouseButton.PRIMARY))
        {
            /*
            stateFightTime = true;
            fightTime.setTextFill(Color.GREEN);
            timer2 = new Timer(1000, e ->
            {
                if(stateFightTime)
                {
                    Platform.runLater(() ->
                    {
                        if(secondFight < 10)
                        {
                            fightTime.setText("" + minuteFight + " : 0" + secondFight);
                            secondFight--;
                        }
                        else
                        {
                            fightTime.setText("" + minuteFight + " : " + secondFight);
                            secondFight--;
                        }
                        if(minuteFight == 0 && secondFight < 0)
                        {
                            stateFightTime = false;
                            stateGoldenScore = true;
                            minuteFight = 0;
                            secondFight = 0;
                            fightTime.setText("" + minuteFight + " : 0" + secondFight);
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
                            fightTime.setText("" + minuteFight + " : 0" + secondFight);
                            secondFight++;
                        }
                        else
                        {
                            fightTime.setText("" + minuteFight + " : " + secondFight);
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
            timer2.setInitialDelay(0);
            timer2.start();

            judoGame.startFightTime();
            fightTime.setTextFill(Color.GREEN);

            Platform.runLater(() ->
            {
                if (judoGame.getSecondFight() < 10)
                {
                    fightTime.setText("" + judoGame.getMinuteFight() + " : 0" + judoGame.getSecondFight());
                }

                else
                {
                    fightTime.setText("" + judoGame.getMinuteFight() + " : " + judoGame.getSecondFight());
                }

                if (judoGame.getMinuteFight() == 0 && judoGame.getSecondFight() < 0)
                {

                    fightTime.setText("" + judoGame.getMinuteFight() + " : 0" + judoGame.getSecondFight());
                }


            });

            Platform.runLater(() ->
            {
                if (judoGame.getSecondFight() < 10)
                {
                    fightTime.setText("" + judoGame.getMinuteFight() + " : 0" + judoGame.getSecondFight());
                }

                else
                {
                    fightTime.setText("" + judoGame.getMinuteFight() + " : " + judoGame.getSecondFight());

                }

            });
            */
        }

        else if(event.getButton().equals(MouseButton.SECONDARY))
        {
            /*
            stateFightTime = false;
            stateGoldenScore = false;
            fightTime.setTextFill(Color.RED);
            timer2.stop();
            if(secondFight < 10)
            {
                fightTime.setText("" + minuteFight + " : 0" + secondFight);
            }
            else
            {
                fightTime.setText("" + minuteFight + " : " + secondFight);
            }


            judoGame.stopFightTime();
            fightTime.setTextFill(Color.RED);

            if(judoGame.getSecondFight() < 10)
            {
                fightTime.setText("" + judoGame.getMinuteFight() + " : 0" + judoGame.getSecondFight());
            }

            else
            {
                fightTime.setText("" + judoGame.getMinuteFight() + " : " + judoGame.getSecondFight());
            }
            */
        }
    }
}