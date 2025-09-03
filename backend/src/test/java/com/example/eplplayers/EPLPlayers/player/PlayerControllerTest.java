    package com.example.eplplayers.EPLPlayers.player;

    import com.example.eplplayers.EPLPlayers.Controller.PlayerController;
    import com.example.eplplayers.EPLPlayers.model.Player;
    import com.example.eplplayers.EPLPlayers.service.JwtService;
    import com.example.eplplayers.EPLPlayers.service.PlayerService;
    import com.fasterxml.jackson.databind.ObjectMapper;
    import org.junit.jupiter.api.Test;

    import static org.mockito.ArgumentMatchers.any;
    import static org.mockito.BDDMockito.given;

    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
    import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
    import org.springframework.test.context.bean.override.mockito.MockitoBean;
    import org.springframework.test.web.servlet.MockMvc;
    import org.springframework.http.MediaType;

    import java.util.Arrays;
    import java.util.List;

    import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
    import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

    @WebMvcTest(PlayerController.class)
    @AutoConfigureMockMvc(addFilters = false)
    public class PlayerControllerTest {

        @Autowired
        private MockMvc mockMvc;

        @MockitoBean
        private PlayerService playerService;

        @MockitoBean
        private JwtService jwtService;

        @Autowired
        private ObjectMapper objectMapper;

        @Test
        void getPlayersByTeamAndPosition_returnsFilteredList() throws Exception {
            Player p = new Player("faker", "korea", "mid", "T1");
            given(playerService.getPlayersByTeamAndPosition("t1", "mid"))
                    .willReturn(List.of(p));

            mockMvc.perform(get("/api/v1/player")
                    .param("team", "t1")
                    .param("position", "mid")
                    .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$[0].team").value("T1"))
                    .andExpect(jsonPath("$[0].position").value("mid"))
                    .andExpect(jsonPath("$[0].name").value("faker"))
                    .andExpect(jsonPath("$[0].nation").value("korea"));
        }

        @Test
        void getPlayersByFromTeam() throws Exception {
            Player p = new Player("faker", "korea", "mid", "T1");
            given(playerService.getPlayersFromTeam("T1"))
                    .willReturn(List.of(p));

            mockMvc.perform(get("/api/v1/player")
                    .param("team", "T1")
                    .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$[0].name").value("faker"));
        }

        @Test
        void getPlayersByPosition_returnsMatching() throws Exception {
            Player p = new Player("De Bruyne", "Man City", "Midfielder", "Belgium");
            given(playerService.getPlayersByPos("midfielder")).willReturn(List.of(p));

            mockMvc.perform(get("/api/v1/player")
                            .param("position", "midfielder")
                            .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$[0].position").value("Midfielder"));
        }

        @Test
        void getPlayersByNation_returnsMatching() throws Exception {
            Player p = new Player("Fernandes", "Portugal", "Midfielder", "Man U");
            given(playerService.getPlayersByNation("portugal")).willReturn(List.of(p));

            mockMvc.perform(get("/api/v1/player")
                            .param("nation", "portugal")
                            .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$[0].nation").value("Portugal"));
        }

        @Test
        void getAllPlayers_whenNoParams_returnsFullList() throws Exception {
            Player p1 = new Player("Saka", "Arsenal", "Midfielder", "England");
            Player p2 = new Player("Haaland", "Man City", "Striker", "Norway");
            given(playerService.getPlayers()).willReturn(Arrays.asList(p1, p2));

            mockMvc.perform(get("/api/v1/player").accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.length()").value(2));
        }

        @Test
        void addPlayer_createsPlayer_andReturnsCreated() throws Exception {
            Player input = new Player("De Bruyne", "Man City", "Midfielder", "Belgium");
            given(playerService.addPlayer(any(Player.class))).willReturn(input);

            mockMvc.perform(post("/api/v1/player")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(objectMapper.writeValueAsString(input)))
                    .andExpect(status().isCreated())
                    .andExpect(jsonPath("$.name").value("De Bruyne"))
                    .andExpect(jsonPath("$.nation").value("Man City"));
        }
    }
