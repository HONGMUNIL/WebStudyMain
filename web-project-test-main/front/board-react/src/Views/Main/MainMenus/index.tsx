import { Box, MenuItem, MenuList, Paper, Stack } from "@mui/material";
import React from "react";

export default function MainMenus() {
    return (
        <>
            <Box sx={{ display:'flex',
                        justifyContent: 'center',
                        backgroundColor: '#323232',
                        height: 1500,
                    }}>
                {/* <Card sx={{mt:5, width: 140, height: 300, backgroundColor: "#676767"}}> */}
                <Stack direction="row" spacing={2} >
                    <Paper sx={{ mt:5, width: 150, height: 300, backgroundColor: "#676767"}}>
                        <MenuList>
                        <MenuItem>Prof</MenuItem>
                        <MenuItem>My account</MenuItem>
                        <MenuItem>Logout</MenuItem>
                        </MenuList>
                    </Paper>
                </Stack>
                {/* </Card> */}
            </Box>
        </>
    )
}