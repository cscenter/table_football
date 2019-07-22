import React from 'react';
import './JoinButton.css';

class JoinButton extends React.Component{
    constructor(props) {
        super(props);
        this.joinTeam = this.joinTeam.bind(this);
    }


    joinTeam(){
        this.props.onJoin(this.props.gameId)
    }

    render () {
        if (this.props.players < 2) {
            return (
                <div>
                    <button onClick={this.joinTeam} disabled={false}>Join Team</button>
                </div>
            );
        } else {
            return (
                <div>
                    <button onClick={this.joinTeam} disabled={true}>Join Team</button>
                </div>
            );
        }
    }
}

export default JoinButton;
