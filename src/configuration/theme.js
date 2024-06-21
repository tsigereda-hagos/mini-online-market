import { createMuiTheme } from '@material-ui/core/styles';

const theme = createMuiTheme({
  palette: {
    primary: {
      main: '#556cd6', // Custom primary color
    },
    secondary: {
      main: '#19857b', // Custom secondary color
    },
    error: {
      main: '#d32f2f',
    },
    background: {
      default: '#fff',
    },
  },
  typography: {
    fontFamily: 'Roboto, sans-serif',
    fontSize: 14,
    button: {
      textTransform: 'none'
    }
  }
});

export default theme;
