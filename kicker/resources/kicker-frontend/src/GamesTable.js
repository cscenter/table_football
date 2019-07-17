import React from 'react';
import GameCell from "./GameCell";

function Users() {
    return <div>
        {
            [1,2,3].map ( (n) => {
                return <GameCell/>
            })
        }
    </div>;
}

export default Users;