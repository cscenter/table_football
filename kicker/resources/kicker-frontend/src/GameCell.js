import React from 'react';
import './GameCell.css';
import Team from "./Team";
import JoinButton from "./JoinButton";

function GameCell() {
    return (
        <div className="GameCell">
            <section className="GameCell-body">
                <Team/>
                <Team/>
            </section>
            <section className="GameCell-body">
                <button>Join</button>
                <button>Join</button>
            </section>
            <footer className="GameCell-footer">
                <button>Start Game</button>
            </footer>
        </div>
    );
}

export default GameCell;
