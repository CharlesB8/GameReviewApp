import React from 'react';
import {BrowserRouter, Route, Routes} from 'react-router-dom';
import './App.css';
import GameList from "./pages/games/GameList";

function App() {
  return (
      <BrowserRouter>
          <Routes>
              <Route path="/" element={<GameList />} />
          </Routes>
      </BrowserRouter>
  );
}

export default App;
