# **************************************************************************** #
#                                                                              #
#                                                         :::      ::::::::    #
#    Makefile                                           :+:      :+:    :+:    #
#                                                     +:+ +:+         +:+      #
#    By: alegent <alegent@student.42.fr>            +#+  +:+       +#+         #
#                                                 +#+#+#+#+#+   +#+            #
#    Created: 2017/02/22 10:22:08 by alegent           #+#    #+#              #
#    Updated: 2017/05/23 13:49:52 by alegent          ###   ########.fr        #
#                                                                              #
# **************************************************************************** #

NAME="AvajLauncher"
CC= javac
OBJ_PATH= out/
SRC_PATH= src/fr/alegent/
SRC_NAME= Aircraft.java \
				AircraftFactory.java \
				Baloon.java \
				Coordinates.java \
				Flyable.java \
				Helicopter.java \
				JetPlane.java \
				Main.java \
				Scenario.java \
				Tower.java \
				WeatherProvider.java \
				WeatherTower.java

SRC= $(addprefix $(SRC_PATH), $(SRC_NAME))

all: $(NAME)

$(NAME):
	@$(CC) $(SRC) -d $(OBJ_PATH)
	@echo "$(NAME) files are compiled. You can execute it with the folling command:"
	@echo "$ java -cp out/ fr.alegent.Main scenario.txt"

clean:
	@rm -rf $(OBJ_PATH)
	@echo "Removing $(NAME) build"

re: clean all

.PHONY: clean fclean re
