import React from 'react';
import './Team.css';
import JoinButton from "./JoinButton";


class Team extends React.Component {
    constructor(props) {
        super(props);
        this.state = {players: props.players, gameId: props.gameId};
    }

    render () {
        let label1 = null;
        if(this.state.players && this.state.players[0]){
            label1 = <label>{this.state.players[0]}</label>
        }
        let label2 = null;
        if(this.state.players && this.state.players[1]){
            label2 = <label>{this.state.players[1]}</label>
        }
        return (
            <div className="Team">
                <div className="Team-body">
                    {label1}
                    {label2}
                    <JoinButton players={this.state.players} onJoin={this.props.onJoin}  gameId={this.state.gameId}/>
                </div>
            </div>
        )
    }
}

export default Team;
