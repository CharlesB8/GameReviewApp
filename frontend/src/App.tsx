import React from 'react';
import {Route, Routes} from 'react-router-dom';
import './App.css';
import GameList from "./pages/games/GameList";
import CreateGame from "./pages/games/CreateGame";
import Games from "./pages/games/Games";

function App() {
  return (
      <Routes>
          <Route index element={<GameList />} />

          <Route path="games" element={<Games />}>
              <Route index element={<GameList />} />
              <Route path="new" element={<CreateGame /> } />
          </Route>

      </Routes>
  );
}

export default App;
