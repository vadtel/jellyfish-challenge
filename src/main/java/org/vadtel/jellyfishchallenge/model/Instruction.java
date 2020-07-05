package org.vadtel.jellyfishchallenge.model;

public enum Instruction{

    R {
        @Override
        public void action(Jellyfish jellyfish) {
            Orientation newOrientation = Orientation.parseOrientation(jellyfish.getOrientation().getRight());
            jellyfish.setOrientation(newOrientation);
        }


    },
    L {
        @Override
        public void action(Jellyfish jellyfish) {
            Orientation newOrientation = Orientation.parseOrientation(jellyfish.getOrientation().getLeft());
            jellyfish.setOrientation(newOrientation);
        }


    },
    F {
        @Override
        public void action(Jellyfish jellyfish) {
            if (!jellyfish.getCell().isScent(jellyfish.getOrientation())) {
                int x = jellyfish.getCell().getX();
                int y = jellyfish.getCell().getY();
                Tank tank = jellyfish.getTank();

                switch (jellyfish.getOrientation()) {
                    case W:
                        if (x == 0) {
                            tank.getCell(x, y).addScent(jellyfish.getOrientation());
                            jellyfish.setLost(true);
                        } else {
                            jellyfish.setCell(tank.getCell(x - 1, y));
                        }
                        break;
                    case E:
                        if (x == tank.getxMax()) {
                            tank.getCell(x, y).addScent(jellyfish.getOrientation());
                            jellyfish.setLost(true);
                        } else {
                            jellyfish.setCell(tank.getCell(x + 1, y));
                        }
                        break;
                    case N:
                        if (y == tank.getyMax()) {
                            tank.getCell(x, y).addScent(jellyfish.getOrientation());
                            jellyfish.setLost(true);
                        } else {
                            jellyfish.setCell(tank.getCell(x, y + 1));
                        }
                        break;
                    case S:
                        if (y == 0) {
                            tank.getCell(x, y).addScent(jellyfish.getOrientation());
                            jellyfish.setLost(true);
                        } else {
                            jellyfish.setCell(tank.getCell(x, y - 1));
                        }
                }

            }
        }

    };

    public abstract void action(Jellyfish jellyfish);
}
