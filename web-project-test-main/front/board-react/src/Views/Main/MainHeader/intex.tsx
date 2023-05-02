import * as React from 'react';

import { AppBar, Box, Button, IconButton, ThemeProvider, Toolbar, Typography, createTheme } from '@mui/material'

import MenuIcon from '@mui/icons-material/Menu';

const darkTheme = createTheme({
    palette: {
        mode: 'dark',
        primary: {
        main: '#393939',
        },
    },
});

export default function MainHeader() {
    return(
        <>
            <Box sx={{ flexGrow: 1 }} >
            <ThemeProvider theme={darkTheme}>
                <AppBar position="static" color='primary' enableColorOnDark>
                    <Toolbar>
                        <IconButton
                            size="large"
                            edge="start"
                            color="inherit"
                            aria-label="menu"
                            sx={{ mr: 2 }}
                        >
                        <MenuIcon />
                        </IconButton>
                            <Typography variant="h6" component="div" sx={{ flexGrow: 1 }}>
                                Rogo
                            </Typography>
                        <Button color="inherit">Login</Button>
                    </Toolbar>
                </AppBar>
            </ThemeProvider>
            </Box>
        </>
    );
}