import React from 'react';
import {Route, Routes} from 'react-router-dom';
import './App.css';
import GameList from "./pages/games/GameList";
import Games from "./pages/games/Games";
import CreateGameForm from "./pages/games/CreateGameFrom";
import GamePage from "./pages/games/GamePage";

function App() {
  return (
      <Routes>
          <Route index element={<GameList />} />

          <Route path="games" element={<Games />}>
              <Route index element={<GameList />} />
              <Route path="new" element={<CreateGameForm /> } />
                  <Route path=":gameId" element={<GamePage />} />
          </Route>

      </Routes>
  );
}

export default App;
