import greenfoot.*;

/**
 * Space. Something for rockets to fly in.
 * 
 * @author Michael Kölling
 * @version 1.1
 */
public class Space extends World
{
    private Counter scoreCounter;
    private int startAsteroids = 3;
    
    /**
     * Create the space and all objects within it.
     */
    public Space() 
    {
        super(600, 500, 1);
        GreenfootImage background = getBackground();
        background.setColor(Color.BLACK);
        background.fill();

        Rocket rocket = new Rocket();
        addObject(rocket, getWidth()/2 + 100, getHeight()/2);

        addAsteroids(startAsteroids);

        scoreCounter = new Counter("Score: ");
        addObject(scoreCounter, 60, 480);

        Explosion.initializeImages();
        ProtonWave.initializeImages();

        addAsteroids(startAsteroids);
        paintStars(300);
        prepare();
    }

    /**
     * Add a given number of asteroids to our world. Asteroids are only added into
     * the left half of the world.
     */
    private void addAsteroids(int count) 
    {
        for(int i = 0; i < count; i++) 
        {
            int x = Greenfoot.getRandomNumber(getWidth()/2);
            int y = Greenfoot.getRandomNumber(getHeight()/2);
            addObject(new Asteroid(), x, y);
        }
    }

    /**
     * adds varrying stars to background of world
     */
    private void paintStars(int count)
    {
        //loop from zero to count
        {
            GreenfootImage background = getBackground();
            for(int i = 0; i < count; i++)
            {
                int x = Greenfoot.getRandomNumber(getWidth());
                int y = Greenfoot.getRandomNumber(getHeight());

                int deltaRed = Greenfoot.getRandomNumber(80) - 40;
                int deltaGreen = Greenfoot.getRandomNumber(80) - 40;
                int deltaBlue = Greenfoot.getRandomNumber(80) - 40;

                int starBrightness = Greenfoot.getRandomNumber(120) + 80;

                Color StarColor = new Color(starBrightness + deltaRed, starBrightness + deltaGreen, starBrightness + deltaBlue);

                int starSize = Greenfoot.getRandomNumber(3) + 1;

                background.setColor(StarColor);
                background.fillOval(x, y, starSize, starSize);
            }

        }
    }

    /**
     * This method is called when the game is over to display the final score.
     */
    public void gameOver() 
    {
        int x = getWidth() / 2;
        int y = getHeight() / 2;
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
    }

    public void updateScore(int addToScore)
    {
      scoreCounter.add(addToScore);
      //int currentScore = new ScoreCounter.getValue();
      //addObject(new ScoreBoard(currentScore),x ,y);
    }
}