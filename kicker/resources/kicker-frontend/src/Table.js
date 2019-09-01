import React from 'react';
import { makeStyles } from '@material-ui/core/styles';
import Table from '@material-ui/core/Table';
import TableBody from '@material-ui/core/TableBody';
import TableCell from '@material-ui/core/TableCell';
import TableHead from '@material-ui/core/TableHead';
import TableRow from '@material-ui/core/TableRow';
import Paper from '@material-ui/core/Paper';
import axios from "axios";
import Team from "./Team";



function createData(name, calories, fat, carbs, protein) {
    return { name, calories, fat, carbs, protein };
}


class SimpleTable extends React.Component{
    constructor(props) {
        super(props);
        this.state = {value: 0, games: []};
        this.joinRed = this.joinRed.bind(this);
        this.joinBlue = this.joinBlue.bind(this);
    }

    componentDidMount() {
        this.timerID = setInterval(() => {
            axios.get(`http://0.0.0.0:8080/api/allGames`)
                .then(response => response.data)
                .then(data => {
                        this.setState({ games: data.data.items });
                    }
                )
        }, 1000);
    }

    componentWillUnmount() {
        clearInterval(this.timerID);
    }
    joinRed(gameId) {
        axios.post(`http://0.0.0.0:8080/api/joinBlue`
            , {userName: this.props.login,
                gameId: gameId},
            {
                headers: {
                    'Content-Type': 'application/json',
                    "Access-Control-Allow-Origin": "*",
                }
            })
    }

    joinBlue(gameId) {
        axios.post(`http://0.0.0.0:8080/api/joinBlue`
            , {userName: this.props.login,
            gameId: gameId},
            {
            headers: {
                'Content-Type': 'application/json',
                "Access-Control-Allow-Origin": "*",
            }
        })
    }

    render() {
        let rows = [];
        if (this.state && this.state.games) {
            rows = this.state.games
        }

        return (
            <Paper>
                <Table>
                    <TableHead>
                        <TableRow>
                            <TableCell>Created</TableCell>
                            <TableCell colSpan={2}>Players</TableCell>
                            <TableCell>Goals</TableCell>
                        </TableRow>
                    </TableHead>
                    <TableBody>
                        {rows.map(row => (
                            <TableRow key={row._id}>
                                <TableCell component="th" scope="row">
                                    {row.creationTime.dayOfMonth}
                                </TableCell>
                                <TableCell component="th" scope="row">
                                    <Team players={row.teamRed} gameId={row._id} onJoin={this.joinBlue}/>
                                </TableCell>
                                <TableCell component="th" scope="row">
                                    <Team players={row.teamBlue} onJoin={this.joinRed}/>
                                </TableCell>
                                <TableCell component="th" scope="row" >
                                    3
                                </TableCell>
                            </TableRow>
                        ))}
                    </TableBody>
                </Table>
            </Paper>
        );
    }
}

export default SimpleTable;