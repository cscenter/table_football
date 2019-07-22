import React from 'react';
import SimpleTable from './Table';
import RegisterLabel from './RegisterLabel';
import axios from 'axios/index'

class GamesPage extends React.Component{
    constructor(props) {
        super(props);
        this.addGame = this.addGame.bind(this);
        this.onSetLogin = this.onSetLogin.bind(this);
        this.onSetPassword = this.onSetPassword.bind(this);
        this.state = {login: '', password: ''};
    }

    addGame() {
        axios.post(`http://0.0.0.0:8080/api/createGame`)
    }

    onSetLogin(login) {
        this.setState({login: login});
    }

    onSetPassword(password) {
        this.setState({password: password});
    }

    render () {
        let registraitionStatus = null;
        if (this.state.login === ''){
            registraitionStatus = <RegisterLabel onSetLogin={this.onSetLogin} onSetPassword={this.onSetPassword}/>
        } else {
            registraitionStatus = <p><label> Логин: {this.state.login}</label></p>
        }
        return (
            <div>
                <button onClick={this.addGame}>Add Game</button>
                {registraitionStatus}
                <SimpleTable/>
            </div>
        )


    }
}

export default GamesPage;
