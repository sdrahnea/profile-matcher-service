package com.fms.repository;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fms.model.Campaign;
import com.fms.model.Player;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

@Slf4j
@Repository
//public interface PlayerRepository extends CrudRepository<Player, String> {
public class PlayerRepository {

    public Optional<Player> findById(String playerId) {
        try {
            File file = new File("src/main/resources/players/player-" + playerId + ".json");

            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            objectMapper.registerModule(new JavaTimeModule());
            Player player = objectMapper.readValue(file, Player.class);

            return Optional.of(player);
        } catch (IOException ioException) {
            log.error("Error during receiving a player: ", ioException);
            return Optional.empty();
        }
    }

    public boolean save(Player player, String playerId) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
            writer.writeValue(new File("src/main/resources/players/player-" + playerId + ".json"), player);

            return true;
        } catch (IOException ioException) {
            log.error("Error during storing the player data: ", ioException);
            return false;
        }
    }

}
