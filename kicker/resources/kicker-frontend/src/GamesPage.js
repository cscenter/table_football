import React from 'react';
import SimpleTable from './Table';
import axios from 'axios/index'

class GamesPage extends React.Component{
    constructor(props) {
        super(props);
        this.addGame = this.addGame.bind(this);
    }

    addGame() {
        axios.post(`http://0.0.0.0:8080/api/createGame`)
    }

    render () {
        return (
            <div>
                <button onClick={this.addGame}>Add Game</button>
                <SimpleTable/>
            </div>
        )
    }
}

export default GamesPage;
