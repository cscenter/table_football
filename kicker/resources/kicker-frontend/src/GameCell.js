import React from 'react';
import './GameCell.css';
import Team from "./Team";
import JoinButton from "./JoinButton";

function GameCell() {
    return (
        <div className="GameCell">

            <div className="GameCell-body">
                <Team name="Team1"/>
                <Team name="Team2"/>
            </div>
            <footer className="GameCell-footer">
                <button>Start Game</button>
            </footer>
        </div>
    );
}

export default GameCell;
