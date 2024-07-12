package models;


    public class Game {
        private String title;
        private String description;
        private double startingPrice;

        public Game(String title, String description, double startingPrice) {
            this.title = title;
            this.description = description;
            this.startingPrice = startingPrice;
        }

        // Getters and setters
        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public double getStartingPrice() {
            return startingPrice;
        }

        public void setStartingPrice(double startingPrice) {
            this.startingPrice = startingPrice;
        }
    }

